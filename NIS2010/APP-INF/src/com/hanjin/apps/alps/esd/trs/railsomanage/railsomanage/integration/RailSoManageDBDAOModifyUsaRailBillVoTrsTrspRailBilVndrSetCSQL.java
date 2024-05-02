/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.09.29 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 SO 정보를 SO Vendor 테이블에 추가 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sctrlOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_RAIL_BIL_VNDR_SET (" ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TRSP_SO_SEQ," ).append("\n"); 
		query.append("SUB_RAIL_SEQ," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("FM_NOD_CD," ).append("\n"); 
		query.append("TO_NOD_CD," ).append("\n"); 
		query.append("ROUT_DTL_SEQ," ).append("\n"); 
		query.append("PAIR_VNDR_SEQ," ).append("\n"); 
		query.append("RAIL_CRR_TP_CD," ).append("\n"); 
		query.append("TRSP_MOD_CD," ).append("\n"); 
		query.append("CRE_OFC_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("LOCL_CRE_DT," ).append("\n"); 
		query.append("LOCL_UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[trsp_so_ofc_cty_cd]," ).append("\n"); 
		query.append("@[trsp_so_seq]," ).append("\n"); 
		query.append("RANK() OVER (ORDER BY B.ROUT_DTL_SEQ) SUB_RAIL_SEQ," ).append("\n"); 
		query.append("B.VNDR_SEQ," ).append("\n"); 
		query.append("B.LNK_ORG_NOD_CD," ).append("\n"); 
		query.append("B.LNK_DEST_NOD_CD," ).append("\n"); 
		query.append("B.ROUT_DTL_SEQ," ).append("\n"); 
		query.append("DECODE(A.INLND_ROUT_INV_BIL_PATT_CD, 'C1T', D.N1ST_VNDR, 'C2T', D.N1ST_VNDR, 'C3T', D.N1ST_VNDR," ).append("\n"); 
		query.append("'C2R', DECODE(RANK() OVER (ORDER BY ROUT_DTL_SEQ), 1, D.N1ST_VNDR, 2, D.N2ND_VNDR)," ).append("\n"); 
		query.append("'C3R', DECODE(RANK() OVER (ORDER BY ROUT_DTL_SEQ), 1, D.N1ST_VNDR, 2, D.N2ND_VNDR, 3, D.N3RD_VNDR)," ).append("\n"); 
		query.append("'S2R', DECODE(RANK() OVER (ORDER BY ROUT_DTL_SEQ), 1, D.N1ST_VNDR, 2, D.N2ND_VNDR)," ).append("\n"); 
		query.append("'S3R', DECODE(RANK() OVER (ORDER BY ROUT_DTL_SEQ), 1, D.N1ST_VNDR, 2, D.N2ND_VNDR, 3, D.N3RD_VNDR)," ).append("\n"); 
		query.append("'C2C', DECODE(RANK() OVER (ORDER BY ROUT_DTL_SEQ), 1, D.N2ND_VNDR, 2, D.N2ND_VNDR)," ).append("\n"); 
		query.append("'C3S', DECODE(RANK() OVER (ORDER BY ROUT_DTL_SEQ), 1, D.N2ND_VNDR, 2, D.N2ND_VNDR, 3, D.N3RD_VNDR)" ).append("\n"); 
		query.append(") PAIR_VNDR_SEQ," ).append("\n"); 
		query.append("B.RAIL_CRR_TP_CD," ).append("\n"); 
		query.append("'RD'," ).append("\n"); 
		query.append("@[sctrlOfcCd]," ).append("\n"); 
		query.append("@[user_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[user_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("B.TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("B.TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sctrlOfcCd])," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sctrlOfcCd])" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_MST A," ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(MIN_SEQ) MIN_SEQ, MAX(MAX_SEQ) MAX_SEQ," ).append("\n"); 
		query.append("MAX(N1ST_VNDR) N1ST_VNDR,	MAX(N2ND_Vndr) N2ND_VNDR, MAX(N3RD_VNDR) N3RD_VNDR" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MIN_SEQ," ).append("\n"); 
		query.append("MAX_SEQ," ).append("\n"); 
		query.append("DECODE(RANK() OVER (ORDER BY ROUT_DTL_SEQ), 1, VNDR_SEQ ) N1ST_VNDR," ).append("\n"); 
		query.append("DECODE(RANK() OVER (ORDER BY ROUT_DTL_SEQ), 2, VNDR_SEQ ) N2ND_VNDR," ).append("\n"); 
		query.append("DECODE(RANK() OVER (ORDER BY ROUT_DTL_SEQ), 3, VNDR_SEQ ) N3RD_VNDR" ).append("\n"); 
		query.append("FROM PRD_INLND_ROUT_DTL A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("MAX(DECODE( @[fm_nod_cd]||@[fm_nod_yard], LNK_ORG_NOD_CD, ROUT_DTL_SEQ)) MIN_SEQ," ).append("\n"); 
		query.append("MAX(DECODE( @[to_nod_cd]||@[to_nod_yard], LNK_DEST_NOD_CD, ROUT_DTL_SEQ)) MAX_SEQ" ).append("\n"); 
		query.append("FROM PRD_INLND_ROUT_DTL" ).append("\n"); 
		query.append("WHERE ROUT_ORG_NOD_CD = @[rout_org_nod_cd]" ).append("\n"); 
		query.append("AND   ROUT_DEST_NOD_CD = @[rout_dest_nod_cd]" ).append("\n"); 
		query.append("AND   TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("AND   ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("GROUP BY ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND   A.ROUT_DEST_NOD_CD = B.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND   A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("AND   A.ROUT_DTL_SEQ BETWEEN B.MIN_SEQ AND B.MAX_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE B.ROUT_ORG_NOD_CD = @[rout_org_nod_cd]" ).append("\n"); 
		query.append("AND   B.ROUT_DEST_NOD_CD = @[rout_dest_nod_cd]" ).append("\n"); 
		query.append("AND   B.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND   B.TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("AND   B.ROUT_DTL_SEQ BETWEEN D.MIN_SEQ AND D.MAX_SEQ" ).append("\n"); 
		query.append("AND   A.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND   A.ROUT_DEST_NOD_CD = B.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND   A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 

	}
}