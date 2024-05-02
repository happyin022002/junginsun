/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchImpCgoManiBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchImpCgoManiBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Import Cargo Manifest Print를 위한 B/L No, 총중량, 포장개수를 조회한다.
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchImpCgoManiBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n"); 
		query.append("FileName : KoreaCustomsReportDBDAOsearchImpCgoManiBlInfoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(BKG.BL_NO,' '),' ','SMLM'||NVL(BKG.BKG_NO,' '),'SMLM'||NVL(BKG.BL_NO,' '))||CHR(10)||SUBSTR(NVL(LOC.LOC_NM,' '),1,18) BL_NO" ).append("\n"); 
		query.append("     , DECODE(DOC.ACT_WGT,0,' ', '1)'||TO_CHAR(DECODE(NVL(DOC.WGT_UT_CD,' '), 'LBS',(DOC.ACT_WGT*0.4536),DOC.ACT_WGT) ,'99999999.99'))||DECODE(DOC.ACT_WGT,0,' ','KGS')||CHR(10)|| /** 총중량 **/" ).append("\n"); 
		query.append("       DECODE(DOC.MEAS_QTY,0,' ','2)'||TO_CHAR(DECODE(NVL(DOC.MEAS_UT_CD,' '),'CBF',(DOC.MEAS_QTY*0.0283),DOC.MEAS_QTY),'99999999.99'))||DECODE(DOC.MEAS_QTY,0,' ','CBM') TOT_WGT" ).append("\n"); 
		query.append("     , DECODE(DOC.PCK_QTY,0,' ', SUBSTR(TO_CHAR(DOC.PCK_QTY,'999999'),2,6))||DECODE(DOC.PCK_QTY,0,' ',NVL(DOC.PCK_TP_CD,' ')) PCK_QTY" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG, MDM_LOCATION LOC, BKG_BL_DOC DOC" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG.DEL_CD = LOC.LOC_CD " ).append("\n"); 
		query.append("   AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 

	}
}