| map()                                                              | flatMap()                                                   |
|--------------------------------------------------------------------|-------------------------------------------------------------|
| 1. it process stream of values                                     | 1. it process stream of stream of values.                   |
| 2. It does only mapping                                            | 2. it does mapping + flattering                             |
| 3. it's mapper function produces Single value for each input value | 3. it's mapper function produces multiple values for each input value. |
| 4. it's one-to-one mapping.                                        | 4. it's one-to-may mapping.                                 |
| 5. Data Transmission: From Stream to Stream.                       | 5. From Stream to Stream<Stream of Stream>                  |
