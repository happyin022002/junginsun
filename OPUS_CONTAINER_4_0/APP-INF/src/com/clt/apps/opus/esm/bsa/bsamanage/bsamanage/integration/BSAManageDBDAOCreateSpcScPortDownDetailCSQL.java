/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BSAManageDBDAOCreateSpcScPortDownDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOCreateSpcScPortDownDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateSpcScPortDownDetail INSERT
	  * </pre>
	  */
	public BSAManageDBDAOCreateSpcScPortDownDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOCreateSpcScPortDownDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO BSA_SLT_CHTR_PORT_DWN (" ).append("\n"); 
		query.append("        BSA_SEQ, " ).append("\n"); 
		query.append("        TRD_CD, " ).append("\n"); 
		query.append("        RLANE_CD, " ).append("\n"); 
		query.append("        DIR_CD, " ).append("\n"); 
		query.append("        VSL_SEQ, " ).append("\n"); 
		query.append("        BSA_OP_CD, " ).append("\n"); 
		query.append("        BSA_OP_JB_CD, " ).append("\n"); 
		query.append("        CRR_CD, " ).append("\n"); 
		query.append("        PORT_SEQ, " ).append("\n"); 
		query.append("        PORT_CD, " ).append("\n"); 
		query.append("        PORT_BSA_CAPA, " ).append("\n"); 
		query.append("        CRE_USR_ID, " ).append("\n"); 
		query.append("        CRE_DT, " ).append("\n"); 
		query.append("        UPD_USR_ID, " ).append("\n"); 
		query.append("        UPD_DT) " ).append("\n"); 
		query.append(" SELECT A.BSA_SEQ, " ).append("\n"); 
		query.append("        A.TRD_CD, " ).append("\n"); 
		query.append("        A.RLANE_CD, " ).append("\n"); 
		query.append("        A.DIR_CD, " ).append("\n"); 
		query.append("        A.VSL_SEQ, " ).append("\n"); 
		query.append("        B.BSA_OP_CD, " ).append("\n"); 
		query.append("        DECODE(B.BSA_OP_JB_CD, '009', '016', B.BSA_OP_JB_CD) BSA_OP_JB_CD,		--20150930.MOD" ).append("\n"); 
		query.append("        B.CRR_CD, " ).append("\n"); 
		query.append("        C.SEQ, " ).append("\n"); 
		query.append("        C.PORT_CD," ).append("\n"); 
		query.append("        --DECODE(B.BSA_OP_JB_CD,'007',DECODE(B.CRR_CD,COM_ConstantMgr_PKG.COM_getCompanyCode_FNC,B.CRR_BSA_CAPA,0),0), " ).append("\n"); 
		query.append("        DECODE(B.BSA_OP_JB_CD,'007',B.CRR_BSA_CAPA,'009',B.CRR_BSA_CAPA, 0), 	--20150930.MOD" ).append("\n"); 
		query.append("        @[cre_usr_id], " ).append("\n"); 
		query.append("        SYSDATE, " ).append("\n"); 
		query.append("        @[upd_usr_id], " ).append("\n"); 
		query.append("        SYSDATE" ).append("\n"); 
		query.append("   FROM BSA_SLT_CHTR_BZC      A, " ).append("\n"); 
		query.append("        BSA_SLT_CHTR_CRR_CAPA B, " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("         SELECT /*+ INDEX_DESC(X IDX1_COA_MON_VVD) */ " ).append("\n"); 
		query.append("                DISTINCT " ).append("\n"); 
		query.append("                X.TRD_CD, " ).append("\n"); 
		query.append("                X.RLANE_CD, " ).append("\n"); 
		query.append("                X.DIR_CD, " ).append("\n"); 
		query.append("                Y.PORT_CD, " ).append("\n"); 
		query.append("				--Y.SEQ" ).append("\n"); 
		query.append("                MIN(Y.SEQ) OVER (PARTITION BY X.TRD_CD, X.RLANE_CD, X.DIR_CD, Y.PORT_CD) AS SEQ		--20150901.MOD : 0030 creation 에러방지" ).append("\n"); 
		query.append("           FROM COA_MON_VVD  X, " ).append("\n"); 
		query.append("                ( " ).append("\n"); 
		query.append("                SELECT NVL(B.TRD_CD          , A.TRD_CD)         TRD_CD, " ).append("\n"); 
		query.append("                       NVL(B.RLANE_CD        , A.RLANE_CD)       RLANE_CD, " ).append("\n"); 
		query.append("                       NVL(B.DIR_CD          , A.DIR_CD)         DIR_CD, " ).append("\n"); 
		query.append("                       NVL(B.IOC_CD          , A.IOC_CD)         IOC_CD, " ).append("\n"); 
		query.append("                       NVL(B.VSL_LANE_TP_CD  , A.VSL_LANE_TP_CD) VSL_LANE_TP_CD, " ).append("\n"); 
		query.append("                       NVL(B.STUP_FLG        , A.STUP_FLG)       STUP_FLG, " ).append("\n"); 
		query.append("                       NVL(B.LANE_APLY_FM_DT, '19000101')        LANE_APLY_FOM_DT, " ).append("\n"); 
		query.append("                       NVL(B.LANE_APLY_TO_DT , '99991231')       LANE_APLY_TO_DT " ).append("\n"); 
		query.append("                  FROM COA_LANE_RGST A " ).append("\n"); 
		query.append("                       FULL OUTER JOIN " ).append("\n"); 
		query.append("                       COA_LANE_TP_HIS B " ).append("\n"); 
		query.append("                    ON (    A.TRD_CD   = B.TRD_CD " ).append("\n"); 
		query.append("                        AND A.RLANE_CD = B.RLANE_CD " ).append("\n"); 
		query.append("                        AND A.DIR_CD   = B.DIR_CD " ).append("\n"); 
		query.append("                        AND A.IOC_CD   = B.IOC_CD) " ).append("\n"); 
		query.append("                 WHERE NVL(A.DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("                   AND A.TRD_CD            = @[trd_cd]" ).append("\n"); 
		query.append("                   AND A.RLANE_CD          = @[rlane_cd]" ).append("\n"); 
		query.append("                   AND A.DIR_CD            = @[dir_cd]" ).append("\n"); 
		query.append("                ) Z, " ).append("\n"); 
		query.append("               (		" ).append("\n"); 
		query.append("               SELECT B.VSL_SLAN_CD, " ).append("\n"); 
		query.append("                      B.PF_SVC_TP_CD, " ).append("\n"); 
		query.append("                      B.SKD_DIR_CD, " ).append("\n"); 
		query.append("                      ROW_NUMBER() OVER (PARTITION BY B.VSL_SLAN_CD, B.PF_SVC_TP_CD, B.SKD_DIR_CD " ).append("\n"); 
		query.append("                                         ORDER BY B.PORT_ROTN_SEQ) SEQ," ).append("\n"); 
		query.append("                      B.PORT_ROTN_SEQ, " ).append("\n"); 
		query.append("                      B.PORT_CD " ).append("\n"); 
		query.append("                 FROM VSK_PF_SKD A, " ).append("\n"); 
		query.append("                      VSK_PF_SKD_DTL B " ).append("\n"); 
		query.append("                 WHERE A.VSL_SLAN_CD   = B.VSL_SLAN_CD " ).append("\n"); 
		query.append("                  AND A.PF_SVC_TP_CD   = B.PF_SVC_TP_CD " ).append("\n"); 
		query.append("                  AND A.SLAN_STND_FLG  = 'Y' " ).append("\n"); 
		query.append("               ) Y " ).append("\n"); 
		query.append("          WHERE SUBSTR(X.RLANE_CD,1,3) = Y.VSL_SLAN_CD " ).append("\n"); 
		query.append("           AND X.DIR_CD              = Y.SKD_DIR_CD " ).append("\n"); 
		query.append("           AND X.TRD_CD              = Z.TRD_CD " ).append("\n"); 
		query.append("           AND X.RLANE_CD            = Z.RLANE_CD " ).append("\n"); 
		query.append("           AND X.IOC_CD              = Z.IOC_CD " ).append("\n"); 
		query.append("           AND X.DIR_CD              = Z.DIR_CD " ).append("\n"); 
		query.append("           AND Z.VSL_LANE_TP_CD      = 'SC' " ).append("\n"); 
		query.append("           AND NVL(Z.STUP_FLG,'N')   = 'Y' " ).append("\n"); 
		query.append("           AND TO_CHAR(X.N1ST_LODG_PORT_ETD_DT,'YYYYMMDD') BETWEEN NVL(Z.LANE_APLY_FOM_DT,'19000101') AND NVL(Z.LANE_APLY_TO_DT, '99991231') " ).append("\n"); 
		query.append("         ) C " ).append("\n"); 
		query.append("  WHERE A.BSA_SEQ       = B.BSA_SEQ " ).append("\n"); 
		query.append("    AND A.TRD_CD        = B.TRD_CD " ).append("\n"); 
		query.append("    AND A.RLANE_CD      = B.RLANE_CD " ).append("\n"); 
		query.append("    AND A.DIR_CD        = B.DIR_CD " ).append("\n"); 
		query.append("    AND A.VSL_SEQ       = B.VSL_SEQ " ).append("\n"); 
		query.append("    AND A.TRD_CD        = C.TRD_CD " ).append("\n"); 
		query.append("    AND A.RLANE_CD      = C.RLANE_CD " ).append("\n"); 
		query.append("    AND A.DIR_CD        = C.DIR_CD " ).append("\n"); 
		query.append("    AND A.BSA_SEQ       = @[bsa_seq]" ).append("\n"); 
		query.append("    AND A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("    AND A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("    AND A.DIR_CD        = @[dir_cd]" ).append("\n"); 
		query.append("    AND A.VSL_SEQ       = @[vsl_seq]" ).append("\n"); 
		query.append("    AND B.BSA_OP_CD     = @[bsa_op_cd]" ).append("\n"); 
		query.append("    AND B.BSA_OP_JB_CD  = DECODE(@[bsa_op_jb_cd], '016', '009', @[bsa_op_jb_cd])		--20150930.MOD" ).append("\n"); 
		query.append("    AND B.CRR_CD        = @[crr_cd]" ).append("\n"); 

	}
}