/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package event;

public interface EventFileSender {
    public void onSending(double percentage);

    public void onStartSending();

    public void onFinish();
}
