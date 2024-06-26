/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchSumQtyByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.18
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.10.18 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchSumQtyByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신 outVO : None, 연관VO: UsaResultCntrVO
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchSumQtyByBlRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchSumQtyByBlRSQL").append("\n"); 
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
		query.append("  NVL(" ).append("\n"); 
		query.append("        SUM(DECODE(DSPO_CD, '1C', CNTR_QTY, 0)) " ).append("\n"); 
		query.append("      + SUM(DECODE(DSPO_CD, '1W', CNTR_QTY, 0)) " ).append("\n"); 
		query.append("      - SUM(DECODE(DSPO_CD, '4E', CNTR_QTY, 0))" ).append("\n"); 
		query.append("        , 0) irc_qty" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("   BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append("  ,BKG_CSTMS_ADV_BL B" ).append("\n"); 
		query.append("  ,BKG_CSTMS_ADV_CNTR C" ).append("\n"); 
		query.append("  ,BKG_CSTMS_ADV_CNTR_RSLT CR" ).append("\n"); 
		query.append(" WHERE C.CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND C.CNTR_NO LIKE TRIM(@[in_cntr])||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("   AND A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND B.CNT_CD     = C.CNT_CD" ).append("\n"); 
		query.append("   AND B.BL_NO      = C.BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND B.MF_NO IS NULL" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND B.CNT_CD = CR.CNT_CD" ).append("\n"); 
		query.append("   AND B.BL_NO =  CR.BL_NO" ).append("\n"); 
		query.append("   AND C.CNTR_NO LIKE CR.CNTR_NO||'%'" ).append("\n"); 

	}
}