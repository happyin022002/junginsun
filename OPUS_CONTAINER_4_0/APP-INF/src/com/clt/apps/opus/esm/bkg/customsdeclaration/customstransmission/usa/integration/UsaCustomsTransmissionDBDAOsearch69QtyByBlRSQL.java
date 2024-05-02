/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearch69QtyByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.18
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.10.18 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearch69QtyByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신 outVO : None, 연관VO: UsaResultCntrVO
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearch69QtyByBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearch69QtyByBlRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUM(CM.PCK_QTY), 0) qty_69" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_BL B" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_CNTR C" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_CNTR_MF CM" ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("   AND C.CNT_CD     = 'US'" ).append("\n"); 
		query.append("   AND C.CNTR_NO    LIKE TRIM(@[in_cntr])||'%'" ).append("\n"); 
		query.append("   AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("   AND A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND C.CNT_CD     = A.CNT_CD" ).append("\n"); 
		query.append("   AND C.BL_NO      = A.BL_NO" ).append("\n"); 
		query.append("   AND A.MF_NO IS NULL" ).append("\n"); 
		query.append("   AND C.CNT_CD = CM.CNT_CD" ).append("\n"); 
		query.append("   AND C.BL_NO = CM.BL_NO" ).append("\n"); 
		query.append("   AND C.CNTR_NO = CM.CNTR_NO" ).append("\n"); 

	}
}