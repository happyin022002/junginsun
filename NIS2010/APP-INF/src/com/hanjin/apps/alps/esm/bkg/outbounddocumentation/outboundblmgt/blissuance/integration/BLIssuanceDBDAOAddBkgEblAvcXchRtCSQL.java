/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOAddBkgEblAvcXchRtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.28
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.04.28 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOAddBkgEblAvcXchRtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BLIssuanceDBDAOAddBkgEblAvcXchRtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ebl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOAddBkgEblAvcXchRtCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_EBL_AVC_XCH_RT" ).append("\n"); 
		query.append("	(BKG_NO" ).append("\n"); 
		query.append("	,BL_NO" ).append("\n"); 
		query.append("	,BKG_EBL_SEQ	" ).append("\n"); 
		query.append("	,CNTR_SEQ" ).append("\n"); 
		query.append("	,DOC_PARA_NO1" ).append("\n"); 
		query.append("	,DOC_PARA_NO2" ).append("\n"); 
		query.append("	,BZC_CURR_CD" ).append("\n"); 
		query.append("	,CHG_XCH_RT" ).append("\n"); 
		query.append("	,IF_FLG" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT)" ).append("\n"); 
		query.append("SELECT	DISTINCT BK.BKG_NO BKG_NO" ).append("\n"); 
		query.append("	,BK.BL_NO BL_NO  " ).append("\n"); 
		query.append("	,@[bkg_ebl_seq]" ).append("\n"); 
		query.append("	,ROWNUM CNTR_SEQ	     " ).append("\n"); 
		query.append("	,BK.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000')) DOC_PARA_NO1" ).append("\n"); 
		query.append("	,BK.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000'))||LTRIM(TO_CHAR(ROWNUM, '0000')) DOC_PARA_NO2" ).append("\n"); 
		query.append("	,RT.CURR_CD  BZC_CURR_CD" ).append("\n"); 
		query.append("	,DECODE(RT.CURR_CD,'USD','1',(SELECT INV_XCH_RT FROM INV_VVD_XCH_RT WHERE VSL_CD = BK.VSL_CD" ).append("\n"); 
		query.append("                                               AND SKD_VOY_NO = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("                                               AND SKD_DIR_CD = BK.SKD_DIR_CD" ).append("\n"); 
		query.append("                                               AND PORT_CD = BK.POL_CD" ).append("\n"); 
		query.append("                                               AND LOCL_CURR_CD = RT.CURR_CD" ).append("\n"); 
		query.append("                                               AND CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("                                               AND SVC_SCP_CD  = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("                                               AND IO_BND_CD = 'O')) CHG_XCH_RT " ).append("\n"); 
		query.append("	,'N' IF_FLG" ).append("\n"); 
		query.append("	,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE CRE_DT    " ).append("\n"); 
		query.append("	,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE UPD_DT  " ).append("\n"); 
		query.append("  FROM	BKG_BOOKING BK" ).append("\n"); 
		query.append("        ,BKG_CHG_RT RT  " ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("   AND RT.CHG_CD = 'OFT'" ).append("\n"); 
		query.append("   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}