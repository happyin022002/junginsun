package com.clt.apps.opus.vop.fcm.trendline.trendline.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.clt.framework.component.common.AbstractValueObject;

public class CoefficientVO  extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CoefficientVO> models = new ArrayList<CoefficientVO>();
	public CoefficientVO() {}

	private String trndLineChtTpCd = null;
	private Double sigmaX = null;
	private Double sigmaX2 = null;
	private Double sigmaX3 = null;
	private Double sigmaX4 = null;
	private int dataCnt = 0;
	private Double sigmaX2y = null;
	private Double sigmaXy = null;
	private Double sigmaY = null;
	private Double coef1 = null;
	private Double coef2 = null;
	private Double coef3 = null;
	
	//C.Spd - CALC_SPD
	private Double sigmaCalcSpd = null;
	private Double sigmaCalcSpdSquare = null;
	private Double sigmaCalcSpdCubed = null;
	private Double sigmaCalcSpdFourth = null;
	//A.Spd - SAIL_AVG_SPD
	private Double sigmaAvgSpd = null;
	private Double sigmaAvgSpdSquare = null;
	private Double sigmaAvgSpdCubed = null;
	private Double sigmaAvgSpdFourth = null;
	//RPM - SAIL_AVG_RPM_PWR
	private Double sigmaRpmPwr = null;
	private Double sigmaRpmPwrSquare = null;
	private Double sigmaRpmPwrCubed = null;
	private Double sigmaRpmPwrFourth = null;
	//LOAD
	private Double sigmaLoad = null;
	private Double sigmaLoadSquare = null;
	private Double sigmaLoadCubed = null;
	private Double sigmaLoadFourth = null;
  //Y절편 관련 데이터 - MN_FOIL_CSM_QTY
	private Double sigmaCalcSpdSquareMefoc = null;
	private Double sigmaCalcSpdMefoc = null;
	private Double sigmaMefoc = null;
	private Double sigmaAvgSpdSquareMefoc = null;
	private Double sigmaAvgSpdMefoc = null;
	private Double sigmaCalcSpdSquareRpmPwr = null;
	private Double sigmaCalcSpdRpmPwr = null;
	private Double sigmaRpmPwrSquareMefoc = null;
	private Double sigmaRpmPwrMefoc = null;
	private Double sigmaLoadSquareMefoc = null;
	private Double sigmaLoadMefoc = null;
	private Double sigmaCalcSpdSquareLoad = null;
	private Double sigmaCalcSpdLoad = null;
	
	public String getTrndLineChtTpCd() {
		return trndLineChtTpCd;
	}
	public void setTrndLineChtTpCd(String trndLineChtTpCd) {
		this.trndLineChtTpCd = trndLineChtTpCd;
	}
	public Double getSigmaX() {
		return sigmaX;
	}
	public void setSigmaX(Double sigmaX) {
		this.sigmaX = sigmaX;
	}
	public Double getSigmaX2() {
		return sigmaX2;
	}
	public void setSigmaX2(Double sigmaX2) {
		this.sigmaX2 = sigmaX2;
	}
	public Double getSigmaX3() {
		return sigmaX3;
	}
	public void setSigmaX3(Double sigmaX3) {
		this.sigmaX3 = sigmaX3;
	}
	public Double getSigmaX4() {
		return sigmaX4;
	}
	public void setSigmaX4(Double sigmaX4) {
		this.sigmaX4 = sigmaX4;
	}
	public int getDataCnt() {
		return dataCnt;
	}
	public void setDataCnt(int dataCnt) {
		this.dataCnt = dataCnt;
	}
	public Double getSigmaX2y() {
		return sigmaX2y;
	}
	public void setSigmaX2y(Double sigmaX2y) {
		this.sigmaX2y = sigmaX2y;
	}
	public Double getSigmaXy() {
		return sigmaXy;
	}
	public void setSigmaXy(Double sigmaXy) {
		this.sigmaXy = sigmaXy;
	}
	public Double getSigmaY() {
		return sigmaY;
	}
	public void setSigmaY(Double sigmaY) {
		this.sigmaY = sigmaY;
	}
	public Double getCoef1() {
		return coef1;
	}
	public void setCoef1(Double coef1) {
		this.coef1 = coef1;
	}
	public Double getCoef2() {
		return coef2;
	}
	public void setCoef2(Double coef2) {
		this.coef2 = coef2;
	}
	public Double getCoef3() {
		return coef3;
	}
	public void setCoef3(Double coef3) {
		this.coef3 = coef3;
	}
	public Double getSigmaCalcSpd() {
		return sigmaCalcSpd;
	}
	public void setSigmaCalcSpd(Double sigmaCalcSpd) {
		this.sigmaCalcSpd = sigmaCalcSpd;
	}
	public Double getSigmaCalcSpdSquare() {
		return sigmaCalcSpdSquare;
	}
	public void setSigmaCalcSpdSquare(Double sigmaCalcSpdSquare) {
		this.sigmaCalcSpdSquare = sigmaCalcSpdSquare;
	}
	public Double getSigmaCalcSpdCubed() {
		return sigmaCalcSpdCubed;
	}
	public void setSigmaCalcSpdCubed(Double sigmaCalcSpdCubed) {
		this.sigmaCalcSpdCubed = sigmaCalcSpdCubed;
	}
	public Double getSigmaCalcSpdFourth() {
		return sigmaCalcSpdFourth;
	}
	public void setSigmaCalcSpdFourth(Double sigmaCalcSpdFourth) {
		this.sigmaCalcSpdFourth = sigmaCalcSpdFourth;
	}
	public Double getSigmaAvgSpd() {
		return sigmaAvgSpd;
	}
	public void setSigmaAvgSpd(Double sigmaAvgSpd) {
		this.sigmaAvgSpd = sigmaAvgSpd;
	}
	public Double getSigmaAvgSpdSquare() {
		return sigmaAvgSpdSquare;
	}
	public void setSigmaAvgSpdSquare(Double sigmaAvgSpdSquare) {
		this.sigmaAvgSpdSquare = sigmaAvgSpdSquare;
	}
	public Double getSigmaAvgSpdCubed() {
		return sigmaAvgSpdCubed;
	}
	public void setSigmaAvgSpdCubed(Double sigmaAvgSpdCubed) {
		this.sigmaAvgSpdCubed = sigmaAvgSpdCubed;
	}
	public Double getSigmaAvgSpdFourth() {
		return sigmaAvgSpdFourth;
	}
	public void setSigmaAvgSpdFourth(Double sigmaAvgSpdFourth) {
		this.sigmaAvgSpdFourth = sigmaAvgSpdFourth;
	}
	public Double getSigmaRpmPwr() {
		return sigmaRpmPwr;
	}
	public void setSigmaRpmPwr(Double sigmaRpmPwr) {
		this.sigmaRpmPwr = sigmaRpmPwr;
	}
	public Double getSigmaRpmPwrSquare() {
		return sigmaRpmPwrSquare;
	}
	public void setSigmaRpmPwrSquare(Double sigmaRpmPwrSquare) {
		this.sigmaRpmPwrSquare = sigmaRpmPwrSquare;
	}
	public Double getSigmaRpmPwrCubed() {
		return sigmaRpmPwrCubed;
	}
	public void setSigmaRpmPwrCubed(Double sigmaRpmPwrCubed) {
		this.sigmaRpmPwrCubed = sigmaRpmPwrCubed;
	}
	public Double getSigmaRpmPwrFourth() {
		return sigmaRpmPwrFourth;
	}
	public void setSigmaRpmPwrFourth(Double sigmaRpmPwrFourth) {
		this.sigmaRpmPwrFourth = sigmaRpmPwrFourth;
	}
	public Double getSigmaCalcSpdSquareMefoc() {
		return sigmaCalcSpdSquareMefoc;
	}
	public void setSigmaCalcSpdSquareMefoc(Double sigmaCalcSpdSquareMefoc) {
		this.sigmaCalcSpdSquareMefoc = sigmaCalcSpdSquareMefoc;
	}
	public Double getSigmaCalcSpdMefoc() {
		return sigmaCalcSpdMefoc;
	}
	public void setSigmaCalcSpdMefoc(Double sigmaCalcSpdMefoc) {
		this.sigmaCalcSpdMefoc = sigmaCalcSpdMefoc;
	}
	public Double getSigmaMefoc() {
		return sigmaMefoc;
	}
	public void setSigmaMefoc(Double sigmaMefoc) {
		this.sigmaMefoc = sigmaMefoc;
	}
	public Double getSigmaAvgSpdSquareMefoc() {
		return sigmaAvgSpdSquareMefoc;
	}
	public void setSigmaAvgSpdSquareMefoc(Double sigmaAvgSpdSquareMefoc) {
		this.sigmaAvgSpdSquareMefoc = sigmaAvgSpdSquareMefoc;
	}
	public Double getSigmaAvgSpdMefoc() {
		return sigmaAvgSpdMefoc;
	}
	public void setSigmaAvgSpdMefoc(Double sigmaAvgSpdMefoc) {
		this.sigmaAvgSpdMefoc = sigmaAvgSpdMefoc;
	}
	public Double getSigmaCalcSpdSquareRpmPwr() {
		return sigmaCalcSpdSquareRpmPwr;
	}
	public void setSigmaCalcSpdSquareRpmPwr(Double sigmaCalcSpdSquareRpmPwr) {
		this.sigmaCalcSpdSquareRpmPwr = sigmaCalcSpdSquareRpmPwr;
	}
	public Double getSigmaCalcSpdRpmPwr() {
		return sigmaCalcSpdRpmPwr;
	}
	public void setSigmaCalcSpdRpmPwr(Double sigmaCalcSpdRpmPwr) {
		this.sigmaCalcSpdRpmPwr = sigmaCalcSpdRpmPwr;
	}
	public Double getSigmaRpmPwrSquareMefoc() {
		return sigmaRpmPwrSquareMefoc;
	}
	public void setSigmaRpmPwrSquareMefoc(Double sigmaRpmPwrSquareMefoc) {
		this.sigmaRpmPwrSquareMefoc = sigmaRpmPwrSquareMefoc;
	}
	public Double getSigmaRpmPwrMefoc() {
		return sigmaRpmPwrMefoc;
	}
	public void setSigmaRpmPwrMefoc(Double sigmaRpmPwrMefoc) {
		this.sigmaRpmPwrMefoc = sigmaRpmPwrMefoc;
	}

	public Double getSigmaLoad() {
		return sigmaLoad;
	}
	public void setSigmaLoad(Double sigmaLoad) {
		this.sigmaLoad = sigmaLoad;
	}
	public Double getSigmaLoadSquare() {
		return sigmaLoadSquare;
	}
	public void setSigmaLoadSquare(Double sigmaLoadSquare) {
		this.sigmaLoadSquare = sigmaLoadSquare;
	}
	public Double getSigmaLoadCubed() {
		return sigmaLoadCubed;
	}
	public void setSigmaLoadCubed(Double sigmaLoadCubed) {
		this.sigmaLoadCubed = sigmaLoadCubed;
	}
	public Double getSigmaLoadFourth() {
		return sigmaLoadFourth;
	}
	public void setSigmaLoadFourth(Double sigmaLoadFourth) {
		this.sigmaLoadFourth = sigmaLoadFourth;
	}
	public Double getSigmaLoadSquareMefoc() {
		return sigmaLoadSquareMefoc;
	}
	public void setSigmaLoadSquareMefoc(Double sigmaLoadSquareMefoc) {
		this.sigmaLoadSquareMefoc = sigmaLoadSquareMefoc;
	}
	public Double getSigmaLoadMefoc() {
		return sigmaLoadMefoc;
	}
	public void setSigmaLoadMefoc(Double sigmaLoadMefoc) {
		this.sigmaLoadMefoc = sigmaLoadMefoc;
	}
	public Double getSigmaCalcSpdSquareLoad() {
		return sigmaCalcSpdSquareLoad;
	}
	public void setSigmaCalcSpdSquareLoad(Double sigmaCalcSpdSquareLoad) {
		this.sigmaCalcSpdSquareLoad = sigmaCalcSpdSquareLoad;
	}
	public Double getSigmaCalcSpdLoad() {
		return sigmaCalcSpdLoad;
	}
	public void setSigmaCalcSpdLoad(Double sigmaCalcSpdLoad) {
		this.sigmaCalcSpdLoad = sigmaCalcSpdLoad;
	}
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
