/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ProductCatalogSceDBDAOSceGetParamRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogSceDBDAOSceGetParamRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ProductCatalogSceDBDAOSceGetParamRSQL
	  * </pre>
	  */
	public ProductCatalogSceDBDAOSceGetParamRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_pu_cy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pc_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_rtn_cy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("door_zn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mt_pu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mt_rtn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogSceDBDAOSceGetParamRSQL").append("\n"); 
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
		query.append("SELECT COP_NO,CNTR_NO,CNTR_TPSZ_CD,PCTL_NO,DECODE(@[pc_mode],'O','Y',OB_TRO_FLG) OB_TRO_FLG,DECODE(@[pc_mode],'I','Y',IB_TRO_FLG) IB_TRO_FLG," ).append("\n"); 
		query.append("DECODE(@[pc_mode],'O',@[door_zn],'I',POR_NOD_CD," ).append("\n"); 
		query.append("DECODE(RCV_TERM_CD,'D',POR_NOD_CD,'S',POR_NOD_CD" ).append("\n"); 
		query.append(",DECODE(POR_CD,POL_CD,DECODE(OUT_BOUND,'%',DECODE(POL_NOD_CD, POR_NOD_CD, '', POR_NOD_CD),POR_NOD_CD),POR_NOD_CD))) POR_NOD_CD, -- 수정 20100503" ).append("\n"); 
		query.append("POL_YD_CD," ).append("\n"); 
		query.append("(CASE WHEN SUBSTR(OCN_BOUND,2,5) <> SUBSTR(POL_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND SUBSTR(OUT_BOUND,-8,5) = SUBSTR(POL_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND SUBSTR(OUT_BOUND,-8,7) <> POL_NOD_CD" ).append("\n"); 
		query.append("AND NVL((SELECT 'Y' FROM PRD_NODE" ).append("\n"); 
		query.append("WHERE NOD_CD =SUBSTR(OUT_BOUND,-8,7)" ).append("\n"); 
		query.append("AND NOD_TP_CD IN ('M','B')),'X') = 'Y'" ).append("\n"); 
		query.append("THEN SUBSTR(OUT_BOUND,-8,7)" ).append("\n"); 
		query.append("END) NEW_POL," ).append("\n"); 
		query.append("(CASE WHEN SUBSTR(OCN_BOUND,-8,5) <> SUBSTR(POD_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND SUBSTR(IN_BOUND,2,5) = SUBSTR(POD_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND SUBSTR(IN_BOUND,2,7) <> POD_NOD_CD" ).append("\n"); 
		query.append("AND NVL((SELECT 'Y' FROM PRD_NODE" ).append("\n"); 
		query.append("WHERE NOD_CD =SUBSTR(IN_BOUND,2,7)" ).append("\n"); 
		query.append("AND NOD_TP_CD IN ('M','B')),'X') = 'Y'" ).append("\n"); 
		query.append("THEN SUBSTR(IN_BOUND,2,7)" ).append("\n"); 
		query.append("END) NEW_POD," ).append("\n"); 
		query.append("'' EUR_CHECK, '' MANUAL_FLAG,'' SKIP_ACT_VAL_FLG," ).append("\n"); 
		query.append("DECODE(@[pc_mode],'O',SUBSTR(@[door_zn],1,5),POR_CD) POR_CD,POL_CD,POD_CD,DECODE(@[pc_mode],'I',SUBSTR(@[door_zn],1,5),DEL_CD) DEL_CD,OB_TRSP_MODE,IB_TRSP_MODE," ).append("\n"); 
		query.append("DECODE(@[pc_mode],'I',@[door_zn],'O',NVL(TRS_DEL_NOD_CD,DEL_NOD_CD)," ).append("\n"); 
		query.append("DECODE(DE_TERM_CD,'D',NVL(TRS_DEL_NOD_CD,DEL_NOD_CD),'S',NVL(TRS_DEL_NOD_CD,DEL_NOD_CD)," ).append("\n"); 
		query.append("DECODE(POD_CD,DEL_CD,DECODE(IN_BOUND,'%',DECODE(POD_NOD_CD, DEL_NOD_CD, '', DEL_NOD_CD)" ).append("\n"); 
		query.append(",NVL(TRS_DEL_NOD_CD,DEL_NOD_CD)),NVL(TRS_DEL_NOD_CD,DEL_NOD_CD)))) DEL_NOD_CD, -- 수정 20100503" ).append("\n"); 
		query.append("DECODE(@[pc_mode],'O',@[full_rtn_cy]) FULL_RTN_YD_CD, DECODE(@[pc_mode],'I',@[full_pu_cy]) FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("DECODE(@[pc_mode],'O','D',RCV_TERM_CD) RCV_TERM_CD,DECODE(@[pc_mode],'I','D',DE_TERM_CD) DE_TERM_CD,NVL(@[mt_pu],MT_PU) MT_PU,NVL(@[mt_rtn],MT_RTN) MT_RTN,IO_BND_CD," ).append("\n"); 
		query.append("OB_INCL_SHTL_SO_FLG,IB_INCL_SHTL_SO_FLG," ).append("\n"); 
		query.append("DECODE(@[pc_mode],'O',@[door_zn],DECODE(@[io_bnd_cd],'O',O_ROUT_ORG_NOD_CD,I_ROUT_ORG_NOD_CD)) ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("DECODE(@[pc_mode],'I',@[door_zn],DECODE(@[io_bnd_cd],'O',O_ROUT_DEST_NOD_CD,I_ROUT_DEST_NOD_CD)) ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("DECODE(@[io_bnd_cd],'O',O_ROUT_SEQ,I_ROUT_SEQ) ROUT_SEQ,CCT,POL_T,POD_T,OUT_BOUND,IN_BOUND,OCN_BOUND," ).append("\n"); 
		query.append("T_VVD,ORG_LOC_CD,DEST_LOC_CD,OCN_SEQ," ).append("\n"); 
		query.append("DECODE(REPLACE(OUT_BOUND, '%', ''), '', OB_TRSP_MODE, '') OB_TRSP_MODE," ).append("\n"); 
		query.append("DECODE(REPLACE(IN_BOUND , '%', ''), '', IB_TRSP_MODE, '') IB_TRSP_MODE," ).append("\n"); 
		query.append("PRD_GET_OCN_VVD_FNC(PCTL_NO,1) VVD1, '' POL1, '' POD1, '' LANE1," ).append("\n"); 
		query.append("PRD_GET_OCN_VVD_FNC(PCTL_NO,2) VVD2, '' POL2, '' POD2, '' LANE2," ).append("\n"); 
		query.append("PRD_GET_OCN_VVD_FNC(PCTL_NO,3) VVD3, '' POL3, '' POD3, '' LANE3," ).append("\n"); 
		query.append("PRD_GET_OCN_VVD_FNC(PCTL_NO,4) VVD4, '' POL4, '' POD4, '' LANE4," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLPT_SEQ_STR,  INSTR(CLPT_SEQ_STR,'N1_POL_SEQ')+10,1)) N1_POL_CLPT_SEQ," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLPT_SEQ_STR,  INSTR(CLPT_SEQ_STR,'N1_POD_SEQ')+10,1)) N1_POD_CLPT_SEQ," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLPT_SEQ_STR,  INSTR(CLPT_SEQ_STR,'N2_POL_SEQ')+10,1)) N2_POL_CLPT_SEQ," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLPT_SEQ_STR,  INSTR(CLPT_SEQ_STR,'N2_POD_SEQ')+10,1)) N2_POD_CLPT_SEQ," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLPT_SEQ_STR,  INSTR(CLPT_SEQ_STR,'N3_POL_SEQ')+10,1)) N3_POL_CLPT_SEQ," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLPT_SEQ_STR,  INSTR(CLPT_SEQ_STR,'N3_POD_SEQ')+10,1)) N3_POD_CLPT_SEQ," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLPT_SEQ_STR,  INSTR(CLPT_SEQ_STR,'N4_POL_SEQ')+10,1)) N4_POL_CLPT_SEQ," ).append("\n"); 
		query.append("TRIM(SUBSTR(CLPT_SEQ_STR,  INSTR(CLPT_SEQ_STR,'N4_POD_SEQ')+10,1)) N4_POD_CLPT_SEQ," ).append("\n"); 
		query.append("NVL(PRM_CUST_FLG, 'N') PRM_CUST_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT H.COP_NO,H.CNTR_NO,BC.CNTR_TPSZ_CD,H.PCTL_NO,H.TRNK_VSL_CD||H.TRNK_SKD_VOY_NO||H.TRNK_SKD_DIR_CD T_VVD," ).append("\n"); 
		query.append("OB_TRO_FLG,IB_TRO_FLG," ).append("\n"); 
		query.append("--NVL(BC.POR_NOD_CD,H.POR_NOD_CD) POR_NOD_CD" ).append("\n"); 
		query.append("-- POR 추가 S 20100202 -----------" ).append("\n"); 
		query.append("-- YARD TERM 일때 로직 추가" ).append("\n"); 
		query.append("DECODE(T2.DOR_NOD_CD,NULL," ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT FM_NOD_CD" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD T" ).append("\n"); 
		query.append("WHERE T.COP_NO = H.COP_NO" ).append("\n"); 
		query.append("AND NVL(T.RPLN_UMCH_FLG,'N') <> 'Y' -- 2010.04.09 추가 by j" ).append("\n"); 
		query.append("AND NVL(T.TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(T.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND T.DELT_FLG ='N'" ).append("\n"); 
		query.append("-- AND T.BKG_RCVDE_TERM_CD ='Y'" ).append("\n"); 
		query.append("AND T.TRSP_SO_TP_CD = 'Y' --Supplement S/O 에 대한Seq 는 참조하지 않게." ).append("\n"); 
		query.append("AND T.TRSP_COST_DTL_MOD_CD = 'CY'	-- TRS Mode 로 확인 #Mod 2010.05.29 by sj" ).append("\n"); 
		query.append("AND T.COST_ACT_GRP_SEQ = (" ).append("\n"); 
		query.append("SELECT MIN(COST_ACT_GRP_SEQ)" ).append("\n"); 
		query.append("FROM SCE_PLN_SO_LIST S" ).append("\n"); 
		query.append("WHERE S.COP_NO = T.COP_NO" ).append("\n"); 
		query.append("AND S.PCTL_IO_BND_CD= 'O'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SUBSTR(T.FM_NOD_CD,1,5) = (SELECT SUBSTR(POR_NOD_CD,1,5) FROM SCE_COP_HDR WHERE COP_NO = S.COP_NO) --SUBSTR(S.N1ST_NOD_CD,1,5)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("), NVL(BC.POR_NOD_CD,H.POR_NOD_CD)),T2.DOR_NOD_CD) POR_NOD_CD," ).append("\n"); 
		query.append("-- 추가 E-----------" ).append("\n"); 
		query.append("BC.POL_YD_CD, H.POL_NOD_CD,H.POD_NOD_CD,DECODE(T.DOR_NOD_CD,NULL,H.DEL_NOD_CD,T.DOR_NOD_CD) DEL_NOD_CD," ).append("\n"); 
		query.append("-- DEL 추가 S 20100202-----------" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TO_NOD_CD" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD T" ).append("\n"); 
		query.append("WHERE T.COP_NO = H.COP_NO" ).append("\n"); 
		query.append("AND NVL(T.RPLN_UMCH_FLG,'N') <> 'Y' -- 2010.04.09 추가 by j" ).append("\n"); 
		query.append("AND NVL(T.TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(T.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND T.DELT_FLG ='N'" ).append("\n"); 
		query.append("-- AND T.BKG_RCVDE_TERM_CD ='Y'" ).append("\n"); 
		query.append("AND T.TRSP_COST_DTL_MOD_CD = 'CY'	-- TRS Mode 로 확인 #Mod 2010.05.29 by sj" ).append("\n"); 
		query.append("AND T.COST_ACT_GRP_SEQ = (" ).append("\n"); 
		query.append("SELECT MAX(COST_ACT_GRP_SEQ)" ).append("\n"); 
		query.append("FROM SCE_PLN_SO_LIST S" ).append("\n"); 
		query.append("WHERE S.COP_NO = T.COP_NO" ).append("\n"); 
		query.append("AND S.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SUBSTR(T.TO_NOD_CD,1,5) = (SELECT SUBSTR(DEL_NOD_CD,1,5) FROM SCE_COP_HDR WHERE COP_NO = S.COP_NO) --DECODE(SUBSTR(S.N4TH_NOD_CD ,1,5), NULL,(DECODE(SUBSTR(S.N3RD_NOD_CD ,1,5), NULL,  SUBSTR(S.N2ND_NOD_CD ,1,5), SUBSTR(S.N3RD_NOD_CD ,1,5) ) ), S.N4TH_NOD_CD  ) -- SUBSTR(S.N1ST_NOD_CD,1,5)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") TRS_DEL_NOD_CD ," ).append("\n"); 
		query.append("SUBSTR(H.POR_NOD_CD,1,5) POR_CD,SUBSTR(H.POL_NOD_CD,1,5) POL_CD,SUBSTR(H.POD_NOD_CD,1,5) POD_CD,DECODE(T.DOR_NOD_CD,NULL,SUBSTR(H.DEL_NOD_CD,1,5),SUBSTR(T.DOR_NOD_CD,1,5)) DEL_CD," ).append("\n"); 
		query.append("NVL(BC.RCV_TERM_CD,M.BKG_RCV_TERM_CD)  RCV_TERM_CD," ).append("\n"); 
		query.append("DECODE(T.DOR_NOD_CD,NULL,NVL(BC.DE_TERM_CD,M.BKG_DE_TERM_CD),'D')  DE_TERM_CD," ).append("\n"); 
		query.append("NVL(T2.FM_NOD_CD,PU.NOD_CD) MT_PU, NVL(T.TO_NOD_CD,RTN.NOD_CD) MT_RTN, @[io_bnd_cd] IO_BND_CD," ).append("\n"); 
		query.append("-- O/B Shuttle S/O Check" ).append("\n"); 
		query.append("(SELECT 'N'" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD T" ).append("\n"); 
		query.append("WHERE T.COP_NO = H.COP_NO" ).append("\n"); 
		query.append("AND T.TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("AND DECODE(T.TRSP_BND_CD,'O',T.TO_NOD_CD,'I',T.FM_NOD_CD) = DECODE(T.TRSP_BND_CD,'O',H.POL_NOD_CD,'I',H.POD_NOD_CD)" ).append("\n"); 
		query.append("AND DECODE(T.TRSP_BND_CD,'O',SUBSTR(H.POL_NOD_CD,1,5),'I',SUBSTR(H.POD_NOD_CD,1,5)) <> DECODE(T.TRSP_BND_CD,'O',SUBSTR(H.POR_NOD_CD,1,5),'I',SUBSTR(H.DEL_NOD_CD,1,5))" ).append("\n"); 
		query.append("AND SUBSTR(T.FM_NOD_CD,1,5) = SUBSTR(T.TO_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND TRIM(T.VIA_NOD_CD) IS NULL" ).append("\n"); 
		query.append("AND TRIM(T.DOR_NOD_CD) IS NULL" ).append("\n"); 
		query.append("AND NVL(T.RPLN_UMCH_FLG,'N') <> 'Y' -- 2010.04.09 추가 by j" ).append("\n"); 
		query.append("AND NVL(T.TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(T.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND ROWNUM =1 ) OB_INCL_SHTL_SO_FLG," ).append("\n"); 
		query.append("-- I/B Shuttle S/O Check" ).append("\n"); 
		query.append("(SELECT 'N'" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD T" ).append("\n"); 
		query.append("WHERE T.COP_NO = H.COP_NO" ).append("\n"); 
		query.append("AND T.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("AND DECODE(T.TRSP_BND_CD,'O',T.TO_NOD_CD,'I',T.FM_NOD_CD) = DECODE(T.TRSP_BND_CD,'O',H.POL_NOD_CD,'I',H.POD_NOD_CD)" ).append("\n"); 
		query.append("AND DECODE(T.TRSP_BND_CD,'O',SUBSTR(H.POL_NOD_CD,1,5),'I',SUBSTR(H.POD_NOD_CD,1,5)) <> DECODE(T.TRSP_BND_CD,'O',SUBSTR(H.POR_NOD_CD,1,5),'I',SUBSTR(H.DEL_NOD_CD,1,5))" ).append("\n"); 
		query.append("AND SUBSTR(T.FM_NOD_CD,1,5) = SUBSTR(T.TO_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND TRIM(T.VIA_NOD_CD) IS NULL" ).append("\n"); 
		query.append("AND TRIM(T.DOR_NOD_CD) IS NULL" ).append("\n"); 
		query.append("AND NVL(T.RPLN_UMCH_FLG,'N') <> 'Y' -- 2010.04.09 추가 by j" ).append("\n"); 
		query.append("AND NVL(T.TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(T.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND ROWNUM =1 ) IB_INCL_SHTL_SO_FLG," ).append("\n"); 
		query.append("O.ROUT_ORG_NOD_CD O_ROUT_ORG_NOD_CD,O.ROUT_DEST_NOD_CD O_ROUT_DEST_NOD_CD,O.ROUT_SEQ O_ROUT_SEQ," ).append("\n"); 
		query.append("I.ROUT_ORG_NOD_CD I_ROUT_ORG_NOD_CD,I.ROUT_DEST_NOD_CD I_ROUT_DEST_NOD_CD,I.ROUT_SEQ I_ROUT_SEQ," ).append("\n"); 
		query.append("OCN.ROUT_ORG_NOD_CD ORG_LOC_CD,OCN.ROUT_DEST_NOD_CD DEST_LOC_CD,OCN.ROUT_SEQ OCN_SEQ, --OCN 정보" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT --PCTL_NO," ).append("\n"); 
		query.append("'N1_POL_SEQ'||MAX(DECODE(R,1, ORG_CLPT_IND_SEQ,' ')) ||" ).append("\n"); 
		query.append("'N1_POD_SEQ'||MAX(DECODE(R,1, DEST_CLPT_IND_SEQ,' ')) ||" ).append("\n"); 
		query.append("'N2_POL_SEQ'||MAX(DECODE(R,2, ORG_CLPT_IND_SEQ,' ')) ||" ).append("\n"); 
		query.append("'N2_POD_SEQ'||MAX(DECODE(R,2, DEST_CLPT_IND_SEQ,' ')) ||" ).append("\n"); 
		query.append("'N3_POL_SEQ'||MAX(DECODE(R,3, ORG_CLPT_IND_SEQ,' ')) ||" ).append("\n"); 
		query.append("'N3_POD_SEQ'||MAX(DECODE(R,3, DEST_CLPT_IND_SEQ,' ')) ||" ).append("\n"); 
		query.append("'N4_POL_SEQ'||MAX(DECODE(R,4, ORG_CLPT_IND_SEQ,' ')) ||" ).append("\n"); 
		query.append("'N4_POD_SEQ'||MAX(DECODE(R,4, DEST_CLPT_IND_SEQ,' ')) CLPT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT D.PCTL_NO,D.ORG_CLPT_IND_SEQ, D.DEST_CLPT_IND_SEQ , ROWNUM R" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL D, PRD_OCN_ROUT O" ).append("\n"); 
		query.append("WHERE D.PCTL_NO = (SELECT PCTL_NO FROM SCE_COP_HDR WHERE COP_NO = @[cop_no] ) --H.PCTL_NO --'R1002170147692570011'" ).append("\n"); 
		query.append("AND D.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("AND D.TRSP_MOD_CD IN ('WD','VD')" ).append("\n"); 
		query.append("AND D.ROUT_ORG_NOD_CD= O.ORG_LOC_CD" ).append("\n"); 
		query.append("AND D.ROUT_DEST_NOD_CD=DEST_LOC_CD" ).append("\n"); 
		query.append("AND D.ROUT_SEQ= O.ROUT_SEQ" ).append("\n"); 
		query.append("AND D.VSL_SLAN_CD IN (O.N1ST_LANE_CD, N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD," ).append("\n"); 
		query.append("(SELECT DECODE(VSL_SVC_TP_CD,'O',D.VSL_SLAN_CD ) FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("WHERE VSL_SLAN_CD = D.VSL_SLAN_CD )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY PCTL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") CLPT_SEQ_STR," ).append("\n"); 
		query.append("(SELECT TRSP_MOD_CD" ).append("\n"); 
		query.append("FROM PRD_INLND_ROUT_MST" ).append("\n"); 
		query.append("WHERE ROUT_ORG_NOD_CD =  O.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND  ROUT_DEST_NOD_CD =  O.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND ROUT_SEQ = O.ROUT_SEQ) OB_TRSP_MODE," ).append("\n"); 
		query.append("(SELECT TRSP_MOD_CD" ).append("\n"); 
		query.append("FROM PRD_INLND_ROUT_MST" ).append("\n"); 
		query.append("WHERE ROUT_ORG_NOD_CD =  I.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND  ROUT_DEST_NOD_CD =  I.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND ROUT_SEQ = I.ROUT_SEQ) IB_TRSP_MODE," ).append("\n"); 
		query.append("(SELECT TO_CHAR(MAX(ARR_ST_DT),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO =H.PCTL_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='O') CCT ," ).append("\n"); 
		query.append("(SELECT TO_CHAR(MIN(ARR_ST_DT),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO =H.PCTL_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='T') POL_T," ).append("\n"); 
		query.append("(SELECT TO_CHAR(MIN(ARR_ST_DT),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO =H.PCTL_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='I') POD_T," ).append("\n"); 
		query.append("PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'O') OUT_BOUND," ).append("\n"); 
		query.append("PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'I') IN_BOUND," ).append("\n"); 
		query.append("PRD_GET_COP_BND_SO_STR_FNC (H.COP_NO,'T') OCN_BOUND," ).append("\n"); 
		query.append("M.PRM_CUST_FLG" ).append("\n"); 
		query.append("FROM SCE_COP_HDR H,SCE_COP_DTL PU, SCE_COP_DTL RTN, BKG_CONTAINER BC," ).append("\n"); 
		query.append("PRD_PROD_CTL_MST M,PRD_PROD_CTL_ROUT_DTL O,PRD_PROD_CTL_ROUT_DTL I,PRD_PROD_CTL_ROUT_DTL OCN,TRS_TRSP_SVC_ORD T, TRS_TRSP_SVC_ORD T2" ).append("\n"); 
		query.append("WHERE H.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND H.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("AND H.PCTL_NO = O.PCTL_NO" ).append("\n"); 
		query.append("AND O.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND O.PCTL_SEQ = (SELECT /*+ INDEX(D2 XPKPRD_PROD_CTL_ROUT_DTL) */" ).append("\n"); 
		query.append("PCTL_SEQ" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL D2" ).append("\n"); 
		query.append("WHERE D2.PCTL_NO = O.PCTL_NO" ).append("\n"); 
		query.append("AND D2.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("AND H.PCTL_NO = I.PCTL_NO" ).append("\n"); 
		query.append("AND I.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND I.PCTL_SEQ = (SELECT /*+ INDEX(D2 XPKPRD_PROD_CTL_ROUT_DTL) */" ).append("\n"); 
		query.append("PCTL_SEQ" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL D2" ).append("\n"); 
		query.append("WHERE D2.PCTL_NO = I.PCTL_NO" ).append("\n"); 
		query.append("AND D2.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("AND H.PCTL_NO = OCN.PCTL_NO" ).append("\n"); 
		query.append("AND OCN.PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("AND OCN.PCTL_SEQ = (SELECT /*+ INDEX(D2 XPKPRD_PROD_CTL_ROUT_DTL) */" ).append("\n"); 
		query.append("PCTL_SEQ" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL D2" ).append("\n"); 
		query.append("WHERE D2.PCTL_NO = OCN.PCTL_NO" ).append("\n"); 
		query.append("AND D2.PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("AND H.COP_NO = T2.COP_NO(+)" ).append("\n"); 
		query.append("AND T2.TRSP_BND_CD(+) ='O'" ).append("\n"); 
		query.append("AND T2.DOR_NOD_CD(+) IS NOT NULL" ).append("\n"); 
		query.append("AND NVL(T2.RPLN_UMCH_FLG(+),'N') <> 'Y' -- 2010.04.09 추가 by j" ).append("\n"); 
		query.append("AND NVL(T2.TRSP_FRST_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(T2.DELT_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.COP_NO = T.COP_NO(+)" ).append("\n"); 
		query.append("AND T.TRSP_BND_CD(+) ='I'" ).append("\n"); 
		query.append("AND T.DOR_NOD_CD(+) IS NOT NULL" ).append("\n"); 
		query.append("AND NVL(T.RPLN_UMCH_FLG(+),'N') <> 'Y' -- 2010.04.09 추가 by j" ).append("\n"); 
		query.append("AND NVL(T.TRSP_FRST_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(T.DELT_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.CNTR_NO = BC.CNTR_NO(+)" ).append("\n"); 
		query.append("AND H.BKG_NO = BC.BKG_NO(+)" ).append("\n"); 
		query.append("AND NVL(H.COP_STS_CD,'N') <> 'X'" ).append("\n"); 
		query.append("AND H.COP_NO = PU.COP_NO(+)" ).append("\n"); 
		query.append("AND PU.ACT_CD(+) = 'MOTYDO'" ).append("\n"); 
		query.append("AND PU.ACT_DT(+) IS NOT NULL" ).append("\n"); 
		query.append("AND H.COP_NO = RTN.COP_NO(+)" ).append("\n"); 
		query.append("AND RTN.ACT_CD(+) = 'MITYAD'" ).append("\n"); 
		query.append("AND RTN.ACT_DT(+) IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}