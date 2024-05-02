/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24CustomsTransmissionDBDAOmakeCorrFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.18 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24CustomsTransmissionDBDAOmakeCorrFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 정정내역 FLATFILE생성
	  * </pre>
	  */
	public Kor24CustomsTransmissionDBDAOmakeCorrFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mdata1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration").append("\n");
		query.append("FileName : Kor24CustomsTransmissionDBDAOmakeCorrFlatFileRSQL").append("\n");
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
		query.append("SELECT" ).append("\n");
		query.append("@[corr_cd]            ||'~'||       /*  정정항목 부호               */" ).append("\n");
		query.append("@[mdata1]             ||'~'||       /*  운항정보 중 일괄 변경의 경우*//* 일괄정정후 내역 */" ).append("\n");
		query.append("''                    ||'~'||       /*  정정후 내역1                */" ).append("\n");
		query.append("''  ||'~'||                         /*  정정후 내역2                */" ).append("\n");
		query.append("''  ||'~'||                         /*  정정후 내역3                */" ).append("\n");
		query.append("''                    ||'~'         /*  정정후 내역4                */" ).append("\n");
		query.append("CORR_DATA" ).append("\n");
		query.append("FROM    DUAL" ).append("\n");

	}
}