/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24CustomsTransmissionDBDAOmakeAutoMACAMDCorrFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.14 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24CustomsTransmissionDBDAOmakeAutoMACAMDCorrFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 단일항목 정정 Info Flat Creation
	  * </pre>
	  */
	public Kor24CustomsTransmissionDBDAOmakeAutoMACAMDCorrFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration ").append("\n");
		query.append("FileName : Kor24CustomsTransmissionDBDAOmakeAutoMACAMDCorrFlatFileRSQL").append("\n");
		query.append("*/").append("\n");
	}

	public String getSQL(){
		return query.toString();
	}

	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT  '{MODI_INFO'        ||'~'|| /*  Start of MODI Block         */" ).append("\n");
		query.append("'MODI_CORR_CD:' ||'BM'  ||'~'|| /*  정정항목 부호               */" ).append("\n");
		query.append("'MODI_VVD:' ||''    ||'~'|| /*  운항정보 중 일괄 변경의 경우*//* 20051027 yong : 일괄정정후 내역 */" ).append("\n");
		query.append("'MODI_FTX1:'    ||'T'   ||'~'|| /*  정정후 내역1                */" ).append("\n");
		query.append("'MODI_FTX2:'    ||''    ||'~'|| /*  정정후 내역2                */" ).append("\n");
		query.append("'MODI_FTX3:'    ||''    ||'~'|| /*  정정후 내역3                */" ).append("\n");
		query.append("'MODI_FTX4:'    ||''    ||'~'|| /*  정정후 내역4                */" ).append("\n");
		query.append("'}MODI_INFO'" ).append("\n");
		query.append("FROM    DUAL" ).append("\n");

	}
}