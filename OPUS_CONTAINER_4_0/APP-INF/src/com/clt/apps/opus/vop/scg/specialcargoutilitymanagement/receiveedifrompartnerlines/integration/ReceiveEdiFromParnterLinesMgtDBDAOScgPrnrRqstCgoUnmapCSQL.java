/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrRqstCgoUnmapCSQL.java
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

public class ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrRqstCgoUnmapCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCG_PRNR_RQST_CGO_UNMAP 데이터 INSERT
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrRqstCgoUnmapCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrRqstCgoUnmapCSQL").append("\n"); 
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
		query.append("INSERT INTO  SCG_PRNR_RQST_CGO_UNMAP" ).append("\n"); 
		query.append("    		(	CRR_CD" ).append("\n"); 
		query.append("			,	BKG_REF_NO" ).append("\n"); 
		query.append("			,	SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("			,	PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,	SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("			,	SPCL_CGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,	EDI_UNMAP_SEQ" ).append("\n"); 
		query.append("			,	EDI_UNMAP_DTL_CD" ).append("\n"); 
		query.append("			,	EDI_UNMAP_DTL_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,	EDI_UNMAP_CORR_RSLT_CD" ).append("\n"); 
		query.append("			--,	EDI_UNMAP_CORR_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,	CRE_USR_ID" ).append("\n"); 
		query.append("			,	CRE_DT" ).append("\n"); 
		query.append("			,	UPD_USR_ID" ).append("\n"); 
		query.append("			,	UPD_DT" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("SELECT       " ).append("\n"); 
		query.append("       			X.EDI_RCVR_ID        					/* CRR_CD            			*/                    " ).append("\n"); 
		query.append("    		,  	X.BKG_REF_NO                         	/* BKG_REF_NO                   */   " ).append("\n"); 
		query.append("    		,  	@[spcl_cgo_rqst_seq]					/* SPCL_CGO_RQST_SEQ            */   " ).append("\n"); 
		query.append("			,  	@[prnr_cgo_rqst_seq]			 		/* PRNR_CGO_RQST_SEQ 			*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    		,  	Y.CNTR_SEQ               				/* SPCL_CNTR_SEQ                */   " ).append("\n"); 
		query.append("    		,  	Y.CGO_SEQ           					/* SPCL_CGO_SEQ                 */   " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("			,	UN.EDI_UNMAP_SEQ" ).append("\n"); 
		query.append("			,	UN.EDI_UNMAP_DTL_CD" ).append("\n"); 
		query.append("			,	UN.EDI_UNMAP_DTL_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,	'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    		,  	'EDI_AUTO_REQUEST'                       /*   CRE_USR_ID                 */   " ).append("\n"); 
		query.append("    		,  	SYSDATE                                  /*   CRE_DT                     */   " ).append("\n"); 
		query.append("    		,  	'EDI_AUTO_REQUEST'                       /*   UPD_USR_ID                 */   " ).append("\n"); 
		query.append("    		,  	SYSDATE                                  /*   UPD_DT                     */   " ).append("\n"); 
		query.append("FROM    		SCG_PRNR_SPCL_CGO_TRSM_HDR     			X" ).append("\n"); 
		query.append("     		,  	SCG_PRNR_SPCL_CGO_TRSM_DTL     			Y" ).append("\n"); 
		query.append("			,	SCG_PRNR_TRSM_DTL_UNMAP					UN" ).append("\n"); 
		query.append("WHERE   		X.TRSM_BND_CD                  			= Y.TRSM_BND_CD" ).append("\n"); 
		query.append("AND     		X.TRSM_DT                      			= Y.TRSM_DT" ).append("\n"); 
		query.append("AND     		X.SPCL_CGO_CATE_CD             			= Y.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("AND     		X.PRNR_SPCL_CGO_SEQ            			= Y.PRNR_SPCL_CGO_SEQ  " ).append("\n"); 
		query.append("AND				Y.TRSM_BND_CD							= UN.TRSM_BND_CD" ).append("\n"); 
		query.append("AND				Y.TRSM_DT								= UN.TRSM_DT" ).append("\n"); 
		query.append("AND				Y.SPCL_CGO_CATE_CD						= UN.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("AND				Y.PRNR_SPCL_CGO_SEQ						= UN.PRNR_SPCL_CGO_SEQ  " ).append("\n"); 
		query.append("AND        		Y.PRNR_SPCL_CGO_SUB_SEQ        			= UN.PRNR_SPCL_CGO_SUB_SEQ                                                       " ).append("\n"); 
		query.append("AND				X.TRSM_BND_CD							= 'I'" ).append("\n"); 
		query.append("AND     		X.SPCL_CGO_CATE_CD             			= 'DG'" ).append("\n"); 
		query.append("AND     		X.TRSM_MZD_CD                  			= 'EDI'" ).append("\n"); 
		query.append("AND				X.TRSM_DT								= TO_DATE(@[trsm_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("AND				X.PRNR_SPCL_CGO_SEQ						= @[prnr_spcl_cgo_seq]" ).append("\n"); 

	}
}