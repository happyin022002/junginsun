/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TransferOrderIssueDBDAOvalidateTroConfirmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.12
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.02.12 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOvalidateTroConfirmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRO Confirm 대상이 있는지 확인한다.
	  * </pre>
	  */
	public TransferOrderIssueDBDAOvalidateTroConfirmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_cy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("door",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOvalidateTroConfirmRSQL").append("\n"); 
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
		query.append("SELECT IRG.ROUT_ORG_NOD_CD,IRG.ROUT_DEST_NOD_CD,IRG.ROUT_SEQ,IRG.FULL_RTN_YD_CD,IRG.FULL_PKUP_YD_CD,IRG.TRSP_MOD_CD " ).append("\n"); 
		query.append("  FROM PRD_INLND_ROUT_MST IRG, BKG_BOOKING BK" ).append("\n"); 
		query.append(" WHERE IRG.PCTL_IO_BND_CD           = @[bound_cd] --BOUND CODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   --OUTBOUND 일때 DOOR ZONE 정보, INBOUND 일때 POL_NOD_CD" ).append("\n"); 
		query.append("   AND IRG.ROUT_ORG_NOD_CD          = decode(@[bound_cd], 'O', @[door],  (SELECT POD_NOD_CD FROM SCE_COP_HDR" ).append("\n"); 
		query.append("                                                                   			WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                                   			AND COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("																			AND NVL(IB_TRO_FLG,'N') = 'N' " ).append("\n"); 
		query.append("                                                                   			AND ROWNUM =1)) " ).append("\n"); 
		query.append("   --INBOUND 일때 DOOR ZONE 정보, OUTBOUND 일때 POD_NOD_CD" ).append("\n"); 
		query.append("   AND IRG.ROUT_DEST_NOD_CD         = decode(@[bound_cd], 'O', (SELECT POL_NOD_CD FROM SCE_COP_HDR" ).append("\n"); 
		query.append("                                                                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                                   AND COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                                                   AND NVL(OB_TRO_FLG,'N') = 'N' " ).append("\n"); 
		query.append("                                                                   AND ROWNUM =1), @[door]) " ).append("\n"); 
		query.append("   --FULL CY는 OUTBOUND일때는 TRO 상의 FULL RETURN CY" ).append("\n"); 
		query.append("   AND NVL(IRG.FULL_RTN_YD_CD,'X')  = NVL(DECODE(@[bound_cd],'O',NVL(@[full_cy],IRG.FULL_RTN_YD_CD),IRG.FULL_RTN_YD_CD),'X')  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   --INBOUND일때는 FULL PICKUP CY" ).append("\n"); 
		query.append("   AND NVL(IRG.FULL_PKUP_YD_CD,'X') = NVL(DECODE(@[bound_cd],'I',NVL(@[full_cy],IRG.FULL_PKUP_YD_CD),IRG.FULL_PKUP_YD_CD),'X')" ).append("\n"); 
		query.append("   AND IRG.TRSP_MOD_CD              = NVL(DECODE(@[trsp_mod_cd],'AL',IRG.TRSP_MOD_CD,@[trsp_mod_cd]),IRG.TRSP_MOD_CD)  " ).append("\n"); 
		query.append("   AND NVL(IRG.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("   and bk.bkg_no                    = @[bkg_no]" ).append("\n"); 

	}
}