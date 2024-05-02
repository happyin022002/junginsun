/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchEuMrnByVvdBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2016.02.12 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchEuMrnByVvdBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1. 2011.01.11 이수진 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
	  *    : EU MRN 정보를 조회한다.
	  * 
	  * 2. 2011.01.31 이수진 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
	  *    : EU MRN 정보에 EU MRN DATE 정보 추가
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchEuMrnByVvdBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchEuMrnByVvdBlRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM EU_MRN_NO, XX.*" ).append("\n"); 
		query.append("FROM ( SELECT EU_MRN_VALUE, MAX(EU_PORT) AS EU_PORT, MAX(EU_MRN_DATE) AS EU_MRN_DATE, EU_MRN_SOURCE" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("                SELECT BL.MVMT_REF_NO EU_MRN_VALUE, BL.CSTMS_PORT_CD EU_PORT, TO_CHAR(SND.SND_DT,'YYYYMMDDHH24MI') EU_MRN_DATE, 'ENS' AS EU_MRN_SOURCE" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_EUR_BL BL" ).append("\n"); 
		query.append("                     , BKG_CSTMS_ADV_EUR_SND SND" ).append("\n"); 
		query.append("                 WHERE BL.MSG_SND_NO = SND.MSG_SND_NO(+)" ).append("\n"); 
		query.append("                   AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                SELECT BL.MVMT_REF_NO EU_MRN_VALUE, BL.CSTMS_PORT_CD EU_PORT, TO_CHAR(SND.SND_DT,'YYYYMMDDHH24MI') EU_MRN_DATE, 'EXS' AS EU_MRN_SOURCE" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_EUR_IO_BL BL" ).append("\n"); 
		query.append("                     , BKG_CSTMS_EUR_IO_SND SND" ).append("\n"); 
		query.append("                 WHERE BL.MSG_SND_NO = SND.MSG_SND_NO(+)" ).append("\n"); 
		query.append("                   AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("        GROUP BY EU_MRN_VALUE, EU_MRN_SOURCE" ).append("\n"); 
		query.append("        ORDER BY EU_MRN_DATE" ).append("\n"); 
		query.append("     ) XX" ).append("\n"); 

	}
}