/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrTrsmDtlUnmapCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrTrsmDtlUnmapCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCG_PRNR_TRSM_DTL_UNMAP 데이터 INSERT
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrTrsmDtlUnmapCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prnr_spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrTrsmDtlUnmapCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_PRNR_TRSM_DTL_UNMAP" ).append("\n"); 
		query.append("      	(  	TRSM_BND_CD" ).append("\n"); 
		query.append("      	,  	TRSM_DT" ).append("\n"); 
		query.append("      	,  	SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("      	,  	PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("		,	PRNR_SPCL_CGO_SUB_SEQ" ).append("\n"); 
		query.append("      	,  	EDI_UNMAP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	CNTR_SEQ" ).append("\n"); 
		query.append("		,	CGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      	,  	EDI_UNMAP_DTL_CD" ).append("\n"); 
		query.append("		,	EDI_UNMAP_DTL_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      	,  	CRE_USR_ID" ).append("\n"); 
		query.append("      	,  	CRE_DT" ).append("\n"); 
		query.append("      	,  	UPD_USR_ID" ).append("\n"); 
		query.append("      	,  	UPD_DT" ).append("\n"); 
		query.append("      	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 		C.TRSM_BND_CD" ).append("\n"); 
		query.append("     	, 	C.TRSM_DT" ).append("\n"); 
		query.append("     	, 	C.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("     	, 	C.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("	 	, 	MP.CGO_MAPG_SEQ						AS NEW_PRNR_SPCL_CGO_SUB_SEQ" ).append("\n"); 
		query.append("      	,   ROW_NUMBER() OVER (PARTITION BY A.TRSM_BND_CD,A.TRSM_DT,A.SPCL_CGO_CATE_CD,A.PRNR_SPCL_CGO_SEQ ORDER BY NVL(UN1.EDI_UNMAP_DTL_CD,UN2.EDI_UNMAP_DTL_CD) ASC)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 	, 	MP.CNTR_SEQ" ).append("\n"); 
		query.append("     	, 	MP.CGO_SEQ      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,  	NVL(UN1.EDI_UNMAP_DTL_CD  ,UN2.EDI_UNMAP_DTL_CD		) " ).append("\n"); 
		query.append("    	,  	NVL(UN1.EDI_UNMAP_DTL_DESC,UN2.EDI_UNMAP_DTL_DESC	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	C.CRE_USR_ID" ).append("\n"); 
		query.append("		,	C.CRE_DT" ).append("\n"); 
		query.append("		,	C.UPD_USR_ID" ).append("\n"); 
		query.append("		,	C.UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM 		SCG_PRNR_SPCL_CGO_TRSM_HDR 		A" ).append("\n"); 
		query.append("    	, 	SCG_PRNR_SPCL_CGO_CNTR_LOG 		B" ).append("\n"); 
		query.append("    	, 	SCG_PRNR_SPCL_CGO_DTL_LOG  		C" ).append("\n"); 
		query.append("		, 	SCG_PRNR_SPCL_CGO_SEQ_MAPG 		MP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  		, 	SCG_PRNR_CNTR_LOG_UNMAP     	UN1" ).append("\n"); 
		query.append("  		, 	SCG_PRNR_CGO_DTL_LOG_UNMAP  	UN2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 		A.TRSM_BND_CD       			= @[trsm_bnd_cd]" ).append("\n"); 
		query.append("AND 		A.TRSM_DT           			= TO_DATE(@[trsm_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND 		A.SPCL_CGO_CATE_CD  			= @[spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("AND 		A.PRNR_SPCL_CGO_SEQ 			= @[prnr_spcl_cgo_seq]" ).append("\n"); 
		query.append("AND 		A.TRSM_BND_CD       			= B.TRSM_BND_CD" ).append("\n"); 
		query.append("AND 		A.TRSM_DT           			= B.TRSM_DT" ).append("\n"); 
		query.append("AND 		A.SPCL_CGO_CATE_CD  			= B.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("AND 		A.PRNR_SPCL_CGO_SEQ 			= B.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("AND 		A.TRSM_BND_CD       			= C.TRSM_BND_CD				" ).append("\n"); 
		query.append("AND 		A.TRSM_DT           			= C.TRSM_DT					" ).append("\n"); 
		query.append("AND 		A.SPCL_CGO_CATE_CD  			= C.SPCL_CGO_CATE_CD		" ).append("\n"); 
		query.append("AND 		A.PRNR_SPCL_CGO_SEQ 			= C.PRNR_SPCL_CGO_SEQ		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("---------------------------------------------------------------------" ).append("\n"); 
		query.append("AND 		A.PRNR_SPCL_CGO_SEQ 			= MP.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("AND 		B.CNTR_SEQ          			= MP.CNTR_SEQ" ).append("\n"); 
		query.append("AND 		C.EDI_ITM_SEQ       			= MP.EDI_ITM_SEQ " ).append("\n"); 
		query.append("---------------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--===================================================================" ).append("\n"); 
		query.append("AND B.TRSM_BND_CD             				= UN1.TRSM_BND_CD         	(+)" ).append("\n"); 
		query.append("AND B.TRSM_DT                 				= UN1.TRSM_DT             	(+)" ).append("\n"); 
		query.append("AND B.SPCL_CGO_CATE_CD        				= UN1.SPCL_CGO_CATE_CD    	(+)" ).append("\n"); 
		query.append("AND B.PRNR_SPCL_CGO_SEQ       				= UN1.PRNR_SPCL_CGO_SEQ   	(+)" ).append("\n"); 
		query.append("AND B.CNTR_SEQ                				= UN1.CNTR_SEQ            	(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND C.TRSM_BND_CD             				= UN2.TRSM_BND_CD         	(+)" ).append("\n"); 
		query.append("AND C.TRSM_DT                 				= UN2.TRSM_DT             	(+)" ).append("\n"); 
		query.append("AND C.SPCL_CGO_CATE_CD        				= UN2.SPCL_CGO_CATE_CD    	(+)" ).append("\n"); 
		query.append("AND C.PRNR_SPCL_CGO_SEQ       				= UN2.PRNR_SPCL_CGO_SEQ   	(+) " ).append("\n"); 
		query.append("AND C.PRNR_SPCL_CGO_SUB_SEQ   				= UN2.PRNR_SPCL_CGO_SUB_SEQ (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NVL(UN1.EDI_UNMAP_DTL_CD,UN2.EDI_UNMAP_DTL_CD) IS NOT NULL" ).append("\n"); 
		query.append("--===================================================================		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT	'' " ).append("\n"); 
		query.append("                FROM 	SCG_PRNR_SPCL_CGO_TRSM_ERR 	ERR" ).append("\n"); 
		query.append("                WHERE 	A.TRSM_BND_CD       		= ERR.TRSM_BND_CD" ).append("\n"); 
		query.append("                AND 	A.TRSM_DT           		= ERR.TRSM_DT" ).append("\n"); 
		query.append("                AND 	A.SPCL_CGO_CATE_CD  		= ERR.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                AND 	A.PRNR_SPCL_CGO_SEQ 		= ERR.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 	'' " ).append("\n"); 
		query.append("                FROM 	SCG_PRNR_SPCL_CGO_DTL_ERR 	ERR" ).append("\n"); 
		query.append("                WHERE 	C.TRSM_BND_CD           	= ERR.TRSM_BND_CD" ).append("\n"); 
		query.append("                AND 	C.TRSM_DT               	= ERR.TRSM_DT" ).append("\n"); 
		query.append("                AND 	C.SPCL_CGO_CATE_CD      	= ERR.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                AND 	C.PRNR_SPCL_CGO_SEQ     	= ERR.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                AND 	C.PRNR_SPCL_CGO_SUB_SEQ 	= ERR.PRNR_SPCL_CGO_SUB_SEQ				" ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}