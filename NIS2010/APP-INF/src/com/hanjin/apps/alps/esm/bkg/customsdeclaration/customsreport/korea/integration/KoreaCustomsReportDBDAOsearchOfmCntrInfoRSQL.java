/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchOfmCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.04.21 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchOfmCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container  Info 조회
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchOfmCntrInfoRSQL(){
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
		query.append("FileName : KoreaCustomsReportDBDAOsearchOfmCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT  NVL(CNTR.CNTR_NO,' ')||'-'||NVL(CNTR.CNTR_TPSZ_CD,' ')||CHR(10)||'/'||NVL(SEAL.CNTR_SEAL_NO,' ') CNTR_INFO" ).append("\n"); 
		query.append(",  DG.CLSS DG_CLSS" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER CNTR," ).append("\n"); 
		query.append("(SELECT DISTINCT BKG_JOIN_FNC(CURSOR(SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE  BKG_NO = @[bkg_no] AND CNTR_NO = BCSN.CNTR_NO ),' ') CNTR_SEAL_NO, CNTR_NO, BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CNTR_SEAL_NO BCSN" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]) SEAL," ).append("\n"); 
		query.append("(SELECT DISTINCT CNTR_NO CNTR, IMDG_CLSS_CD CLSS" ).append("\n"); 
		query.append("FROM   BKG_DG_CGO" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]) DG" ).append("\n"); 
		query.append("WHERE CNTR.BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("AND   CNTR.BKG_NO = SEAL.BKG_NO(+)" ).append("\n"); 
		query.append("AND   CNTR.CNTR_NO = SEAL.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   CNTR.CNTR_NO = DG.CNTR(+)" ).append("\n"); 
		query.append("ORDER BY CNTR.CNTR_NO, SEAL.CNTR_SEAL_NO" ).append("\n"); 

	}
}