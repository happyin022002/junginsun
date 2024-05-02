/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EdiTransmitHistoryDBDAOSearchDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EdiTransmitHistoryDBDAOSearchDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public EdiTransmitHistoryDBDAOSearchDtlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.integration").append("\n"); 
		query.append("FileName : EdiTransmitHistoryDBDAOSearchDtlListRSQL").append("\n"); 
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
		query.append("SELECT   NO" ).append("\n"); 
		query.append("       , EDI_MSG_REF_NO" ).append("\n"); 
		query.append("	   , SLAN_CD" ).append("\n"); 
		query.append("	   , BKG_REF_NO" ).append("\n"); 
		query.append("	   , POL_CD" ).append("\n"); 
		query.append("	   , POD_CD" ).append("\n"); 
		query.append("	   , VSL_CD" ).append("\n"); 
		query.append("	   , SKD_VOY_NO" ).append("\n"); 
		query.append("	   , SKD_DIR_CD" ).append("\n"); 
		query.append("	   , EDI_MSG_STS_CD" ).append("\n"); 
		query.append("	   , ERR_KND_CD" ).append("\n"); 
		query.append("	   , CGO_OPR_CD" ).append("\n"); 
		query.append("	   , METHOD" ).append("\n"); 
		query.append("	   , ERR_DTL_CD" ).append("\n"); 
		query.append("	   , ERR_DTL_RMK" ).append("\n"); 
		query.append("	   , MSG_ACK_RSLT_CD" ).append("\n"); 
		query.append("	   , ORG_MSG_RCVR_NM" ).append("\n"); 
		query.append("	   , TRAN_IF_DATE" ).append("\n"); 
		query.append("	   , ARK_IF_DATE" ).append("\n"); 
		query.append("	   , MSG_RJCT_RSN" ).append("\n"); 
		query.append("	   , TRSM_STS_CD" ).append("\n"); 
		query.append("	   , ORG_MSG_KEY_NO" ).append("\n"); 
		query.append("	   , DCGO_REF_NO" ).append("\n"); 
		query.append("	   , EDI_ITM_SEQ" ).append("\n"); 
		query.append(" FROM 	(" ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("               DENSE_RANK() OVER(ORDER BY A.PRNR_SPCL_CGO_SEQ DESC, VSL_CD, SKD_VOY_NO ,SKD_DIR_CD, EDI_MSG_STS_CD) NO" ).append("\n"); 
		query.append("             , A.EDI_MSG_REF_NO" ).append("\n"); 
		query.append("             , A.SLAN_CD" ).append("\n"); 
		query.append("             , A.BKG_REF_NO" ).append("\n"); 
		query.append("             , A.POL_CD" ).append("\n"); 
		query.append("             , A.POD_CD" ).append("\n"); 
		query.append("             , A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.EDI_MSG_STS_CD" ).append("\n"); 
		query.append("             , A.ERR_KND_CD" ).append("\n"); 
		query.append("             , A.CGO_OPR_CD" ).append("\n"); 
		query.append("             , 'EDI' METHOD" ).append("\n"); 
		query.append("             , DECODE(B.ERR_DTL_CD, NULL, E.ERR_DTL_CD, B.ERR_DTL_CD)    ERR_DTL_CD" ).append("\n"); 
		query.append("             , DECODE(B.ERR_DTL_RMK, NULL, E.ERR_DTL_RMK, B.ERR_DTL_RMK) ERR_DTL_RMK" ).append("\n"); 
		query.append("             , C.MSG_ACK_RSLT_CD" ).append("\n"); 
		query.append("             , C.ORG_MSG_RCVR_NM" ).append("\n"); 
		query.append("             , A.UPD_DT              TRAN_IF_DATE" ).append("\n"); 
		query.append("             , C.UPD_DT              ARK_IF_DATE" ).append("\n"); 
		query.append("			 , A.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("             , C.MSG_RJCT_RSN" ).append("\n"); 
		query.append("             , C.TRSM_STS_CD" ).append("\n"); 
		query.append("             , DECODE(A.TRSM_BND_CD, 'I', C.ORG_MSG_KEY_NO, A.EDI_IF_ID) ORG_MSG_KEY_NO" ).append("\n"); 
		query.append("			 , A.MAPG_CRR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			 , D.DCGO_REF_NO" ).append("\n"); 
		query.append("			 , D.EDI_ITM_SEQ" ).append("\n"); 
		query.append("          FROM SCG_PRNR_SPCL_CGO_TRSM_HDR 	A" ).append("\n"); 
		query.append("             , SCG_PRNR_SPCL_CGO_TRSM_ERR 	B" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT    AK.TRSM_BND_CD" ).append("\n"); 
		query.append("                        , AK.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                        , AK.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                        , AK.ORG_MSG_KEY_NO" ).append("\n"); 
		query.append("                        , AK.TRSM_STS_CD" ).append("\n"); 
		query.append("                        , AK.MSG_RJCT_RSN" ).append("\n"); 
		query.append("                        , AK.ORG_MSG_RCVR_NM" ).append("\n"); 
		query.append("                        , AK.MSG_ACK_RSLT_CD" ).append("\n"); 
		query.append("                        , MAX(AK.UPD_DT)	AS UPD_DT" ).append("\n"); 
		query.append("                FROM      SCG_PRNR_SPCL_CGO_TRSM_ACK AK" ).append("\n"); 
		query.append("                GROUP BY  AK.TRSM_BND_CD" ).append("\n"); 
		query.append("                        , AK.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                        , AK.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                        , AK.ORG_MSG_KEY_NO" ).append("\n"); 
		query.append("                        , AK.TRSM_STS_CD" ).append("\n"); 
		query.append("                        , AK.MSG_RJCT_RSN" ).append("\n"); 
		query.append("                        , AK.ORG_MSG_RCVR_NM" ).append("\n"); 
		query.append("                        , AK.MSG_ACK_RSLT_CD" ).append("\n"); 
		query.append("               )   							C" ).append("\n"); 
		query.append("             , SCG_PRNR_SPCL_CGO_DTL_LOG  	D" ).append("\n"); 
		query.append("             , SCG_PRNR_SPCL_CGO_DTL_ERR  	E" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append(" 		   AND A.TRSM_MZD_CD              	= 'EDI'							--::EDI, EML::--" ).append("\n"); 
		query.append("		   " ).append("\n"); 
		query.append("		   AND A.TRSM_BND_CD              	= D.TRSM_BND_CD 		(+)" ).append("\n"); 
		query.append("		   " ).append("\n"); 
		query.append("		   AND A.TRSM_DT           			= D.TRSM_DT				(+)" ).append("\n"); 
		query.append("           AND A.SPCL_CGO_CATE_CD  			= D.SPCL_CGO_CATE_CD	(+)" ).append("\n"); 
		query.append("           AND A.PRNR_SPCL_CGO_SEQ 			= D.PRNR_SPCL_CGO_SEQ	(+)" ).append("\n"); 
		query.append("           AND A.TRSM_BND_CD       			= B.TRSM_BND_CD			(+)" ).append("\n"); 
		query.append("           AND A.TRSM_DT           			= B.TRSM_DT				(+)" ).append("\n"); 
		query.append("           AND A.SPCL_CGO_CATE_CD  			= B.SPCL_CGO_CATE_CD	(+)" ).append("\n"); 
		query.append("           AND A.PRNR_SPCL_CGO_SEQ 			= B.PRNR_SPCL_CGO_SEQ	(+)" ).append("\n"); 
		query.append("           /*" ).append("\n"); 
		query.append("           AND A.TRSM_DT           			= C.TRSM_DT				(+)" ).append("\n"); 
		query.append("           */" ).append("\n"); 
		query.append("           AND A.SPCL_CGO_CATE_CD  			= C.SPCL_CGO_CATE_CD	(+)" ).append("\n"); 
		query.append("           AND A.PRNR_SPCL_CGO_SEQ 			= C.PRNR_SPCL_CGO_SEQ	(+)" ).append("\n"); 
		query.append("           AND D.TRSM_BND_CD       			= E.TRSM_BND_CD			(+)" ).append("\n"); 
		query.append("           AND D.TRSM_DT           			= E.TRSM_DT				(+)" ).append("\n"); 
		query.append("           AND D.SPCL_CGO_CATE_CD  			= E.SPCL_CGO_CATE_CD	(+)" ).append("\n"); 
		query.append("           AND D.PRNR_SPCL_CGO_SEQ 			= E.PRNR_SPCL_CGO_SEQ	(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${bkg_ref_no} != '')" ).append("\n"); 
		query.append("           AND A.BKG_REF_NO = @[bkg_ref_no]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${trsm_bnd_cd} != '')" ).append("\n"); 
		query.append("           AND A.TRSM_BND_CD       = @[trsm_bnd_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   #if (${trsm_bnd_cd} == 'O')      						-- << SEND >> --" ).append("\n"); 
		query.append("               #if (${crr_cd} != '')" ).append("\n"); 
		query.append("		       AND A.MAPG_CRR_CD       = @[crr_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("		   #elseif (${trsm_bnd_cd} == 'I')							-- << RECEIVE >> --" ).append("\n"); 
		query.append("               #if (${cgo_opr_cd} != '')" ).append("\n"); 
		query.append("		       AND A.CGO_OPR_CD        = @[cgo_opr_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("           AND A.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${pol_cd} != '')" ).append("\n"); 
		query.append("           AND A.POL_CD       = @[pol_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${pod_cd} != '')" ).append("\n"); 
		query.append("           AND A.POD_CD       = @[pod_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY 	PRNR_SPCL_CGO_SEQ	DESC" ).append("\n"); 
		query.append("		, 	ARK_IF_DATE 		DESC" ).append("\n"); 
		query.append("		, 	VSL_CD				ASC" ).append("\n"); 
		query.append("		, 	SKD_VOY_NO 			ASC" ).append("\n"); 
		query.append("		,	SKD_DIR_CD			ASC" ).append("\n"); 
		query.append("		, 	EDI_MSG_STS_CD		ASC" ).append("\n"); 
		query.append("		,	DCGO_REF_NO			ASC" ).append("\n"); 
		query.append("		,	ERR_DTL_CD			ASC" ).append("\n"); 

	}
}