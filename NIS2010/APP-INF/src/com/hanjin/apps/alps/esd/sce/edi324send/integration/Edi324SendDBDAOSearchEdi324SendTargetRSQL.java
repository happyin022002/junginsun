/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Edi324SendDBDAOSearchEdi324SendTargetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi324send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi324SendDBDAOSearchEdi324SendTargetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화면에서 입력된 vndr_seq, bkg_no, cntr_no, vvd  전송대상을 조회하는 쿼리
	  * </pre>
	  */
	public Edi324SendDBDAOSearchEdi324SendTargetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi324send.integration").append("\n"); 
		query.append("FileName : Edi324SendDBDAOSearchEdi324SendTargetRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(D XPKSCE_COP_DTL) */" ).append("\n"); 
		query.append("       G.VNDR_SEQ" ).append("\n"); 
		query.append("     , D.COP_NO" ).append("\n"); 
		query.append("     , D.COP_DTL_SEQ" ).append("\n"); 
		query.append("     , TO_CHAR(D.ACT_DT,'YYYY-MM-DD HH24:MI:SS') POL_DEP_ACT_DT" ).append("\n"); 
		query.append("     , D.NOD_CD POL_YD_CD" ).append("\n"); 
		query.append("     , D.VSL_CD" ).append("\n"); 
		query.append("     , D.SKD_VOY_NO" ).append("\n"); 
		query.append("     , D.SKD_DIR_CD" ).append("\n"); 
		query.append("     , H.BKG_NO" ).append("\n"); 
		query.append("     , H.CNTR_NO" ).append("\n"); 
		query.append("     , P.N1ST_NOD_CD ORG_YD_CD" ).append("\n"); 
		query.append("     , DECODE(P.N4TH_NOD_CD, NULL, DECODE(P.N3RD_NOD_CD, NULL, P.N2ND_NOD_CD, P.N3RD_NOD_CD), P.N4TH_NOD_CD ) DEST_YD_CD" ).append("\n"); 
		query.append("     , @[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("     , @[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("  FROM EDI_324_GRP G" ).append("\n"); 
		query.append("     , SCE_COP_HDR H" ).append("\n"); 
		query.append("     , SCE_PLN_SO_LIST P" ).append("\n"); 
		query.append("     , SCE_COP_DTL D" ).append("\n"); 
		query.append(" WHERE 1=1   " ).append("\n"); 
		query.append("   AND H.COP_NO = H.MST_COP_NO" ).append("\n"); 
		query.append("   AND H.COP_NO = P.COP_NO" ).append("\n"); 
		query.append("   AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND G.CTRL_OFC_CD = P.CTRL_OFC_CD            --'PHXSA'" ).append("\n"); 
		query.append("   AND P.PCTL_COST_MOD_CD = 'C'" ).append("\n"); 
		query.append("   AND G.COST_ACT_GRP_CD = P.COST_ACT_GRP_CD    --'IYRD'" ).append("\n"); 
		query.append("   AND G.VNDR_SEQ = P.N1ST_VNDR_SEQ             --119993" ).append("\n"); 
		query.append("   AND G.EDI_SND_FLG = 'Y'" ).append("\n"); 
		query.append("   AND G.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("   AND D.ACT_CD LIKE 'F___D_'" ).append("\n"); 
		query.append("   AND SUBSTR(D.ACT_CD,3,1) IN ( 'V','W' )" ).append("\n"); 
		query.append("   AND D.ACT_STS_CD IN('F','C','N')" ).append("\n"); 
		query.append("   AND D.COP_DTL_SEQ LIKE '4%'" ).append("\n"); 
		query.append("   #if(${vndr_seq} != 'ALL')" ).append("\n"); 
		query.append("   AND G.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND H.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("   ORDER BY  D.VSL_CD || D.SKD_VOY_NO ||  D.SKD_DIR_CD" ).append("\n"); 

	}
}