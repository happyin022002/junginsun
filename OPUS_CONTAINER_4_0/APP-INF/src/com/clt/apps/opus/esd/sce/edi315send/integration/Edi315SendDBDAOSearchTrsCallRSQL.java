/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOSearchTrsCallRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.01
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.04.01 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchTrsCallRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for SearchTrsCall
	  * </pre>
	  */
	public Edi315SendDBDAOSearchTrsCallRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchTrsCallRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("      ,BL_NO" ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("      ,COP_NO" ).append("\n"); 
		query.append("      ,EVENT_YARD" ).append("\n"); 
		query.append("--    ,to_char(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), sysdate, substr(EVENT_YARD, 1, 5)), 'yyyymmddhh24miss') event_dt" ).append("\n"); 
		query.append("      ,TO_CHAR(ACT_DT, 'yyyymmddhh24miss') event_dt" ).append("\n"); 
		query.append("      ,'COP' call_From" ).append("\n"); 
		query.append("      ,COP_DTL_SEQ" ).append("\n"); 
		query.append("  FROM (SELECT H.BKG_NO" ).append("\n"); 
		query.append("              ,H.CNTR_NO" ).append("\n"); 
		query.append("              ,H.COP_NO" ).append("\n"); 
		query.append("              ,D.NOD_CD EVENT_YARD" ).append("\n"); 
		query.append("              ,D.ACT_DT" ).append("\n"); 
		query.append("              ,B.BL_NO" ).append("\n"); 
		query.append("              ,D.COP_DTL_SEQ" ).append("\n"); 
		query.append("          FROM sce_pln_so_list S" ).append("\n"); 
		query.append("              ,SCE_COP_HDR     H" ).append("\n"); 
		query.append("              ,bkg_booking     B" ).append("\n"); 
		query.append("              ,SCE_COP_DTL     D" ).append("\n"); 
		query.append("         WHERE S.cop_no = @[e_cop_no]" ).append("\n"); 
		query.append("           AND S.COST_ACT_GRP_SEQ = @[e_cost_act_grp_seq]" ).append("\n"); 
		query.append("           AND S.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("           AND D.ACT_CD = 'FITZAD'   -- inbound Door " ).append("\n"); 
		query.append("           AND B.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("           AND S.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("           AND S.COST_ACT_GRP_CD like 'ID%T%'" ).append("\n"); 
		query.append("           AND S.COP_NO = H.COP_NO) V" ).append("\n"); 

	}
}