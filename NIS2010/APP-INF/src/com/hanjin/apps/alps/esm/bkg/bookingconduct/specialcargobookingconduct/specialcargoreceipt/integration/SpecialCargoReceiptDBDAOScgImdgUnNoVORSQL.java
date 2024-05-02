/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOScgImdgUnNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.25
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.07.25 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOScgImdgUnNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ScgImdgUnNoVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOScgImdgUnNoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prp_shp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOScgImdgUnNoVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("         B1.IMDG_UN_NO" ).append("\n"); 
		query.append("       , B1.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("       , B1.PRP_SHP_NM" ).append("\n"); 
		query.append("       , B1.IMDG_CLSS_CD" ).append("\n"); 
		query.append("       , B1.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("       , B1.IMDG_SUBS_RSK_LBL_RMK" ).append("\n"); 
		query.append("       , B1.IMDG_MRN_POLUT_CD" ).append("\n"); 
		query.append("       , B1.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("       , B1.IMDG_LMT_QTY" ).append("\n"); 
		query.append("       , B1.IMDG_LMT_QTY_MEAS_UT_CD" ).append("\n"); 
		query.append("       , B1.IMDG_EXPT_QTY_CD" ).append("\n"); 
		query.append("       , B1.IMDG_EMER_NO" ).append("\n"); 
		query.append("       , B1.IMDG_STWG_CATE_CD" ).append("\n"); 
		query.append("       , B1.FLSH_PNT_TEMP_CTNT" ).append("\n"); 
		query.append("       , B1.EMER_RSPN_GID_NO" ).append("\n"); 
		query.append("       , B1.EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append("       , B1.PSA_NO" ).append("\n"); 
		query.append("       , B1.N1ST_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append("       , B1.N2ND_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append("       , B1.N3RD_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append("       , B1.N4TH_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append("       , B1.PKG_AUTH_NO" ).append("\n"); 
		query.append("       , B1.LK_PORT_AUTH_NO" ).append("\n"); 
		query.append("       , B1.IMDG_SBST_PPT_DESC" ).append("\n"); 
		query.append("       , B1.CFR_RPT_QTY" ).append("\n"); 
		query.append("       , B1.CFR_PSN_INH_ZN_CD" ).append("\n"); 
		query.append("       , B1.CFR_TOXC_CD" ).append("\n"); 
		query.append("       , B1.CFR_DG_WET_CD" ).append("\n"); 
		query.append("       , B1.CFR_RSTR_PORT_NM" ).append("\n"); 
		query.append("       , B1.CFR_RSTR_OPR_NM" ).append("\n"); 
		query.append("       , B1.CFR_XTD_CLSS_CD" ).append("\n"); 
		query.append("       , B1.HCDG_FLG" ).append("\n"); 
		query.append("       , B1.HCDG_DPND_QTY_FLG" ).append("\n"); 
		query.append("       , B1.HCDG_RMK" ).append("\n"); 
		query.append("       , B1.N1ST_IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("       , B1.N2ND_IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("       , B1.N3RD_IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("       , B1.N1ST_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("       , B1.N2ND_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("       , B1.N3RD_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("       , B1.N4TH_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("       , B1.N5TH_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("       , B1.N1ST_IMDG_IBC_INSTR_CD" ).append("\n"); 
		query.append("       , B1.N2ND_IMDG_IBC_INSTR_CD" ).append("\n"); 
		query.append("       , B1.N3RD_IMDG_IBC_INSTR_CD" ).append("\n"); 
		query.append("       , B1.N4TH_IMDG_IBC_INSTR_CD" ).append("\n"); 
		query.append("       , B1.N5TH_IMDG_IBC_INSTR_CD" ).append("\n"); 
		query.append("       , B1.N1ST_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("       , B1.N2ND_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("       , B1.N3RD_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("       , B1.N4TH_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("       , B1.N5TH_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("       , B1.N1ST_IMDG_UN_TNK_INSTR_CD" ).append("\n"); 
		query.append("       , B1.N2ND_IMDG_UN_TNK_INSTR_CD" ).append("\n"); 
		query.append("       , B1.N1ST_IMDG_TNK_INSTR_PROVI_CD" ).append("\n"); 
		query.append("       , B1.N2ND_IMDG_TNK_INSTR_PROVI_CD" ).append("\n"); 
		query.append("       , B1.N3RD_IMDG_TNK_INSTR_PROVI_CD" ).append("\n"); 
		query.append("       , B1.N4TH_IMDG_TNK_INSTR_PROVI_CD" ).append("\n"); 
		query.append("       , B1.N5TH_IMDG_TNK_INSTR_PROVI_CD" ).append("\n"); 
		query.append("       , B1.HCDG_PCK_RSTR_DESC" ).append("\n"); 
		query.append("       , B1.HCDG_INTMD_BC_RSTR_DESC" ).append("\n"); 
		query.append("       , B1.HCDG_TNK_RSTR_DESC" ).append("\n"); 
		query.append("       , B1.SEGR_DESC" ).append("\n"); 
		query.append("       , B1.CLR_LIV_QTR_STWG_FLG" ).append("\n"); 
		query.append("       , B1.IMDG_FD_STUF_STWG_CD" ).append("\n"); 
		query.append("       , B1.IMDG_HT_SRC_STWG_CD" ).append("\n"); 
		query.append("       , B1.SEGR_AS_FOR_IMDG_CLSS_FLG" ).append("\n"); 
		query.append("       , B1.SEGR_AS_FOR_IMDG_CLSS_CD" ).append("\n"); 
		query.append("       , B1.AWAY_FM_IMDG_CLSS_FLG" ).append("\n"); 
		query.append("       , B1.SPRT_FM_IMDG_CLSS_FLG" ).append("\n"); 
		query.append("       , B1.AWAY_FM_IMDG_SEGR_GRP_FLG" ).append("\n"); 
		query.append("       , B1.SPRT_FM_IMDG_SEGR_GRP_FLG" ).append("\n"); 
		query.append("       , B1.IMDG_TBL_NO" ).append("\n"); 
		query.append("       , B1.IMDG_UN_NO_HLD_FLG" ).append("\n"); 
		query.append("       , B1.CRE_USR_ID" ).append("\n"); 
		query.append("       , B1.CRE_DT" ).append("\n"); 
		query.append("       , B1.UPD_USR_ID" ).append("\n"); 
		query.append("       , B1.UPD_DT" ).append("\n"); 
		query.append("       , B1.IMDG_LMT_QTY_DESC" ).append("\n"); 
		query.append("       , B1.IMDG_EXPT_QTY_DESC" ).append("\n"); 
		query.append("       , B2.IMDG_SPCL_PROVI_NO" ).append("\n"); 
		query.append("       , B4.IMDG_TEC_NM" ).append("\n"); 
		query.append("       , B4.IMDG_CTRL_TEMP" ).append("\n"); 
		query.append("       , B4.IMDG_EMER_TEMP" ).append("\n"); 
		query.append("       , CONCAT(B1.IMDG_LMT_QTY, B1.IMDG_LMT_QTY_MEAS_UT_CD) LIMITED_QTY" ).append("\n"); 
		query.append("       , ( SELECT IMDG_SUBS_RSK_LBL_CD FROM (SELECT ROW_NUMBER() OVER (PARTITION BY IMDG_UN_NO, IMDG_UN_NO_SEQ ORDER BY IMDG_SUBS_RSK_LBL_CD) RNUM, IMDG_UN_NO, IMDG_UN_NO_SEQ, IMDG_SUBS_RSK_LBL_CD FROM SCG_IMDG_SUBS_RSK_LBL WHERE IMDG_SUBS_RSK_LBL_CD <> 0) WHERE IMDG_UN_NO = B1.IMDG_UN_NO AND IMDG_UN_NO_SEQ = B1.IMDG_UN_NO_SEQ AND rnum =1 ) SRL1" ).append("\n"); 
		query.append("       , ( SELECT IMDG_SUBS_RSK_LBL_CD FROM (SELECT ROW_NUMBER() OVER (PARTITION BY IMDG_UN_NO, IMDG_UN_NO_SEQ ORDER BY IMDG_SUBS_RSK_LBL_CD) RNUM, IMDG_UN_NO, IMDG_UN_NO_SEQ, IMDG_SUBS_RSK_LBL_CD FROM SCG_IMDG_SUBS_RSK_LBL WHERE IMDG_SUBS_RSK_LBL_CD <> 0) WHERE IMDG_UN_NO = B1.IMDG_UN_NO AND IMDG_UN_NO_SEQ = B1.IMDG_UN_NO_SEQ AND rnum =2 ) SRL2" ).append("\n"); 
		query.append("       , ( SELECT IMDG_SUBS_RSK_LBL_CD FROM (SELECT ROW_NUMBER() OVER (PARTITION BY IMDG_UN_NO, IMDG_UN_NO_SEQ ORDER BY IMDG_SUBS_RSK_LBL_CD) RNUM, IMDG_UN_NO, IMDG_UN_NO_SEQ, IMDG_SUBS_RSK_LBL_CD FROM SCG_IMDG_SUBS_RSK_LBL WHERE IMDG_SUBS_RSK_LBL_CD <> 0) WHERE IMDG_UN_NO = B1.IMDG_UN_NO AND IMDG_UN_NO_SEQ = B1.IMDG_UN_NO_SEQ AND rnum =3 ) SRL3" ).append("\n"); 
		query.append("       , ( SELECT IMDG_SUBS_RSK_LBL_CD FROM (SELECT ROW_NUMBER() OVER (PARTITION BY IMDG_UN_NO, IMDG_UN_NO_SEQ ORDER BY IMDG_SUBS_RSK_LBL_CD) RNUM, IMDG_UN_NO, IMDG_UN_NO_SEQ, IMDG_SUBS_RSK_LBL_CD FROM SCG_IMDG_SUBS_RSK_LBL WHERE IMDG_SUBS_RSK_LBL_CD <> 0) WHERE IMDG_UN_NO = B1.IMDG_UN_NO AND IMDG_UN_NO_SEQ = B1.IMDG_UN_NO_SEQ AND rnum =4 ) SRL4" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("            SELECT A2.CRR_CD" ).append("\n"); 
		query.append("            FROM   BKG_VVD A1" ).append("\n"); 
		query.append("                  ,MDM_VSL_CNTR A2" ).append("\n"); 
		query.append("                  ,SCG_IMDG_CRR_RSTR A3" ).append("\n"); 
		query.append("            WHERE  A1.VSL_CD = A2.VSL_CD" ).append("\n"); 
		query.append("            AND    A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND    A2.CRR_CD = A3.VSL_OPR_TP_CD" ).append("\n"); 
		query.append("            AND    A3.IMDG_CRR_RSTR_EXPT_CD = 'R'" ).append("\n"); 
		query.append("            AND    B1.IMDG_UN_NO = NVL(A3.IMDG_UN_NO, B1.IMDG_UN_NO)" ).append("\n"); 
		query.append("            AND    B1.IMDG_UN_NO_SEQ  = NVL(A3.IMDG_UN_NO_SEQ , B1.IMDG_UN_NO_SEQ)" ).append("\n"); 
		query.append("            AND    B1.IMDG_CLSS_CD = NVL(A3.IMDG_CLSS_CD,B1.IMDG_CLSS_CD)" ).append("\n"); 
		query.append("            AND    ROWNUM =1" ).append("\n"); 
		query.append("         ) CRR_CD" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("            SELECT SUBSTR(XMLAGG(XMLELEMENT(NM, '|' || M.IMDG_SEGR_GRP_NM) ORDER BY M.IMDG_SEGR_GRP_NO).EXTRACT('//text()'), 2)" ).append("\n"); 
		query.append("            FROM   SCG_IMDG_SEGR_GRP_DTL D" ).append("\n"); 
		query.append("                  ,SCG_IMDG_SEGR_GRP M" ).append("\n"); 
		query.append("            WHERE  1 = 1" ).append("\n"); 
		query.append("            AND    D.IMDG_SEGR_GRP_NO = M.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("            AND    D.IMDG_UN_NO = B1.IMDG_UN_NO" ).append("\n"); 
		query.append("         ) IMDG_SEGR_GRP_NM" ).append("\n"); 
		query.append("FROM     SCG_IMDG_UN_NO B1" ).append("\n"); 
		query.append("       , SCG_IMDG_UN_NO_SPCL_PROVI B2" ).append("\n"); 
		query.append("       , SCG_IMDG_UN_NO_ORG_RACT B4" ).append("\n"); 
		query.append("WHERE    B1.IMDG_UN_NO = B2.IMDG_UN_NO (+)" ).append("\n"); 
		query.append("AND      B1.IMDG_UN_NO = B4.IMDG_UN_NO (+)" ).append("\n"); 
		query.append("AND      B1.IMDG_UN_NO_SEQ = B2.IMDG_UN_NO_SEQ (+)" ).append("\n"); 
		query.append("AND      B1.IMDG_UN_NO_SEQ = B4.IMDG_UN_NO_SEQ (+)" ).append("\n"); 
		query.append("AND      B2.IMDG_SPCL_PROVI_NO(+) = 274" ).append("\n"); 
		query.append("AND	     B1.IMDG_UN_NO LIKE @[imdg_un_no]||'%'" ).append("\n"); 
		query.append("#if (${imdg_un_no_seq} != '')" ).append("\n"); 
		query.append("AND	     B1.IMDG_UN_NO_SEQ LIKE @[imdg_un_no_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	     UPPER(B1.PRP_SHP_NM) LIKE '%'||@[prp_shp_nm]||'%'" ).append("\n"); 
		query.append("AND	     B1.IMDG_CLSS_CD LIKE @[imdg_clss_cd]||'%'" ).append("\n"); 
		query.append("ORDER BY B1.IMDG_UN_NO, B1.IMDG_UN_NO_SEQ" ).append("\n"); 

	}
}