package tr.com.cbc.credit.register.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kredi")
public class Credit implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "kredinumarasi")
	private String krediNumarasi;
	@Column(name = "tckn")
	private String tckn;
	@Column(name = "bankaadi")
	private String bankaadi;
	@Column(name = "tutar")
	private String tutar;
	@Column(name = "kredituru")
	private String krediTuru;

	@Column(name = "kayittarihi")
	private String kayittarihi;

	public String getKayittarihi() {
		return kayittarihi;
	}

	public void setKayittarihi(String kayittarihi) {
		this.kayittarihi = kayittarihi;
	}

	public String getTckn() {
		return tckn;
	}

	public void setTckn(String tckn) {
		this.tckn = tckn;
	}

	public String getKrediNumarasi() {
		return krediNumarasi;
	}

	public void setKrediNumarasi(String krediNumarasi) {
		this.krediNumarasi = krediNumarasi;
	}

	public String getBankaadi() {
		return bankaadi;
	}

	public void setBankaadi(String bankaadi) {
		this.bankaadi = bankaadi;
	}

	public String getTutar() {
		return tutar;
	}

	public void setTutar(String tutar) {
		this.tutar = tutar;
	}

	public String getKrediTuru() {
		return krediTuru;
	}

	public void setKrediTuru(String krediTuru) {
		this.krediTuru = krediTuru;
	}

	public Credit() {

	}

	@Override
	public String toString() {
		return "Credit [krediNumarasi=" + krediNumarasi + ", tckn=" + tckn + ", bankaadi=" + bankaadi + ", tutar="
				+ tutar + ", krediTuru=" + krediTuru + ", kayittarihi=" + kayittarihi + "]";
	}

	public Credit(String krediNumarasi, String tckn, String bankaadi, String tutar, String krediTuru,
			String kayittarihi) {
		super();
		this.krediNumarasi = krediNumarasi;
		this.tckn = tckn;
		this.bankaadi = bankaadi;
		this.tutar = tutar;
		this.krediTuru = krediTuru;
		this.kayittarihi = kayittarihi;
	}

}
