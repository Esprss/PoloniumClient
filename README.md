# Polonium Client
## 🇬🇧 English README
### About
The **Polonium Client** is a simple, lightweight utility client built on **Fabric** for Minecraft 1.21.
This project was developed primarily as a **development framework** to experiment with essential client features, focusing on implementing core module structures, settings, and successfully fixing complex compilation issues across Mixin injections and the Fabric API on a Linux development environment.
### Status: NON-FUNCTIONAL (Framework Only) ⚠️
**Please Note:** The client exists currently as a robust *coding framework*. While the entire module architecture (Modules, Settings, Managers) is fully functional and the project **compiles successfully without errors**, **the client currently crashes upon game initialization** (`:runClient` fails to launch Minecraft). This is due to an unresolved issue related to the Fabric Entrypoint implementation for this version.
The code is hosted here to demonstrate the working class structure and the successful resolution of all dependency and compilation problems.
### Implemented Features (Framework Ready)
The following core modules are fully integrated into the framework structure and are ready for the final implementation logic:
  
  * **FOV (Field of View) Mod:**
      * **Category:** Render
      * **Description:** Designed to override the default Minecraft Field of View setting. It includes the necessary Mixins to handle both standard FoV and the dynamic FoV changes that occur during item interactions (e.g., using a bow).
  * **Aspect Ratio Mod:**
      * **Category:** Render
      * **Description:** This module includes the logic to force the game window to adopt a specific, custom aspect ratio, overriding the dimensions set by the display.
  * **HUD (Heads-Up Display) Mod:**
      * **Category:** Render
      * **Description:** Serves as the primary placeholder and framework for rendering custom information directly onto the player's screen (e.g., coordinates, status effects, speed indicators).
### Installation (for compilation)

This project requires **Java 21** to compile correctly.

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/Esprss/PoloniumClient.git
    cd PoloniumClient
    ```
2.  **Run the client (attempt):**
    ```bash
    ./gradlew runClient
    ```
    *(The compilation phase will succeed, but the game launch will likely fail until the main entrypoint issue is resolved.)*


## 🇷🇺 Русский
### О проекте
**Polonium Client** — это простой и легковесный вспомогательный клиент, основанный на **Fabric** для Minecraft 1.21.
Этот проект изначально создавался как **рабочий каркас** для тестирования ключевых функций клиента. Основное внимание уделялось успешной интеграции основной структуры модулей, настроек и устранению сложных ошибок компиляции, связанных с инжекциями Mixin и настройкой Fabric API.
### Статус: НЕ РАБОТАЕТ (Только каркас) ⚠️
**Обратите внимание:** На данный момент клиент представляет собой **полностью рабочий фреймворк**. Хотя вся архитектура модулей (Модули, Настройки, Менеджеры) полностью собрана и проект **компилируется без ошибок**, **сам клиент сейчас вылетает при инициализации игры** (`:runClient` не может запустить Minecraft). Причина в нерешенной проблеме, связанной с главной точкой входа Fabric (Entrypoint) для этой версии.
Код размещен здесь для демонстрации рабочей структуры классов и успешного решения всех проблем с зависимостями и компиляцией.
### Реализованный функционал (Каркас готов)
Следующие основные модули полностью интегрированы в структуру фреймворка и готовы к добавлению финальной логики:
  
  * **FOV (Field of View) Модуль:**
      * **Категория:** Рендеринг
      * **Описание:** Предназначен для переопределения стандартного поля зрения Minecraft. Включает необходимые Mixin'ы для управления как основным FoV, так и динамическим FoV, который меняется при использовании предметов (например, прицеливание из лука).
  * **Aspect Ratio (Соотношение Сторон) Модуль:**

      * **Категория:** Рендеринг
      * **Описание:** Модуль, позволяющий принудительно задавать пользовательское соотношение сторон экрана, игнорируя стандартные настройки окна.

  * **HUD (Heads-Up Display) Модуль:**

      * **Категория:** Рендеринг
      * **Описание:** Служит основным каркасом для рендеринга пользовательской информации непосредственно на экране игрока (например, координаты, текущий статус, скорость).

### Инструкции по компиляции
Для компиляции проекта требуется **Java 21**.
1.  **Клонируйте репозиторий:**
    ```bash
    git clone https://github.com/Esprss/PoloniumClient.git
    cd PoloniumClient
    ```
2.  **Запуск клиента (попытка):**
    ```bash
    ./gradlew runClient
    ```
    *(Фаза компиляции пройдет успешно, но запуск игры, вероятно, завершится ошибкой, пока не будет решена проблема с основной точкой входа Fabric.)*
