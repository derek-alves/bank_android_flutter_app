import 'dart:async';

import 'package:event_bus/src/events/events.dart';

class EventbusImplementation {
  EventbusImplementation._();
  static final EventbusImplementation _singleton = EventbusImplementation._();
  factory EventbusImplementation() => _singleton;

  final _bus = StreamController<Event>.broadcast();

  static emit<T extends Event>(T event) {
    _singleton._bus.sink.add(event);
  }

  static Stream<T> on<T extends Event>() {
    if (T == dynamic) {
      return _singleton._bus.stream as Stream<T>;
    } else {
      return _singleton._bus.stream.where((event) => event is T).cast<T>();
    }
  }
}
