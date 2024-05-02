/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOsearchDgCntrStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.15 
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

public class ReceiveEdiFromParnterLinesMgtDBDAOsearchDgCntrStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDgCgoCnt
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOsearchDgCntrStatusRSQL(){
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
		params.put("cntr_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOsearchDgCntrStatusRSQL").append("\n"); 
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
		query.append("SELECT    	DECODE(CNT.CNTR_REF_NO,@[cntr_ref_no],'Y','N')  AS CNTR_CNT" ).append("\n"); 
		query.append("    	,  	HDR.TRSM_BND_CD" ).append("\n"); 
		query.append("    	,  	TO_CHAR(HDR.TRSM_DT, 'YYYYMMDD')         		AS TRSM_DT" ).append("\n"); 
		query.append("    	,  	HDR.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("    	,  	HDR.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("FROM     	SCG_PRNR_SPCL_CGO_TRSM_HDR   HDR" ).append("\n"); 
		query.append("    	,   SCG_PRNR_SPCL_CGO_CNTR_LOG   CNT" ).append("\n"); 
		query.append("WHERE     	1 = 1" ).append("\n"); 
		query.append("AND     	HDR.TRSM_BND_CD            	= CNT.TRSM_BND_CD" ).append("\n"); 
		query.append("AND     	HDR.TRSM_DT                	= CNT.TRSM_DT" ).append("\n"); 
		query.append("AND     	HDR.SPCL_CGO_CATE_CD       	= CNT.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("AND     	HDR.PRNR_SPCL_CGO_SEQ      	= CNT.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     	HDR.TRSM_MZD_CD            	= 'EDI'              --::EDI, EML::--" ).append("\n"); 
		query.append("AND     	HDR.BKG_REF_NO             	= @[bkg_ref_no]" ).append("\n"); 
		query.append("AND     	HDR.TRSM_BND_CD            	= @[trsm_bnd_cd]" ).append("\n"); 
		query.append("AND      	HDR.CGO_OPR_CD        		= @[cgo_opr_cd]" ).append("\n"); 
		query.append("AND      	HDR.VSL_CD          		= @[vsl_cd]" ).append("\n"); 
		query.append("AND      	HDR.SKD_VOY_NO        		= @[skd_voy_no]" ).append("\n"); 
		query.append("AND      	HDR.SKD_DIR_CD        		= @[skd_dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("----AND      	HDR.POL_CD          		= [pol_cd]" ).append("\n"); 
		query.append("----AND      	HDR.POD_CD          		= [pod_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       	HDR.ERR_KND_CD             	= 'O'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     	HDR.PRNR_SPCL_CGO_SEQ      = (  SELECT  MAX(PRNR_SPCL_CGO_SEQ)" ).append("\n"); 
		query.append("                      						FROM   	SCG_PRNR_SPCL_CGO_TRSM_HDR  B" ).append("\n"); 
		query.append("                      						WHERE   1 = 1" ).append("\n"); 
		query.append("                         					AND   	B.BKG_REF_NO          		= HDR.BKG_REF_NO" ).append("\n"); 
		query.append("                        					AND   	B.TRSM_BND_CD         		= HDR.TRSM_BND_CD" ).append("\n"); 
		query.append("                         					AND   	B.TRSM_MZD_CD               = HDR.TRSM_MZD_CD" ).append("\n"); 
		query.append("                                      		AND     B.ERR_KND_CD              	= HDR.ERR_KND_CD" ).append("\n"); 
		query.append("                                      		AND     B.CGO_OPR_CD              	= HDR.CGO_OPR_CD" ).append("\n"); 
		query.append("                                      		AND     B.VSL_CD                  	= HDR.VSL_CD" ).append("\n"); 
		query.append("                                      		AND     B.SKD_VOY_NO              	= HDR.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      		AND     B.SKD_DIR_CD              	= HDR.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      		AND     B.POL_CD                  	= HDR.POL_CD" ).append("\n"); 
		query.append("                                      		AND     B.POD_CD                  	= HDR.POD_CD" ).append("\n"); 
		query.append("                       					)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--  SELECT    DECODE(DTL.CNTR_REF_NO,[cntr_ref_no],'Y','N')  AS CNTR_CNT" ).append("\n"); 
		query.append("--      ,  HDR.TRSM_BND_CD" ).append("\n"); 
		query.append("--      ,  TO_CHAR(HDR.TRSM_DT, 'YYYYMMDD')         AS TRSM_DT" ).append("\n"); 
		query.append("--      ,  HDR.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("--      ,  HDR.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("--  FROM     SCG_PRNR_SPCL_CGO_TRSM_HDR   HDR" ).append("\n"); 
		query.append("--      ,   SCG_PRNR_SPCL_CGO_DTL_LOG    DTL" ).append("\n"); 
		query.append("--      ,   SCG_PRNR_SPCL_CGO_CNTR_LOG   CNT" ).append("\n"); 
		query.append("--  WHERE     1 = 1" ).append("\n"); 
		query.append("--  AND     HDR.TRSM_MZD_CD            = 'EDI'              --::EDI, EML::--" ).append("\n"); 
		query.append("--  AND     HDR.BKG_REF_NO             = [bkg_ref_no]" ).append("\n"); 
		query.append("--  AND     HDR.TRSM_BND_CD            = [trsm_bnd_cd]" ).append("\n"); 
		query.append("--  AND      HDR.CGO_OPR_CD        = [cgo_opr_cd]" ).append("\n"); 
		query.append("--  AND      HDR.VSL_CD          = [vsl_cd]" ).append("\n"); 
		query.append("--  AND      HDR.SKD_VOY_NO        = [skd_voy_no]" ).append("\n"); 
		query.append("--  AND      HDR.SKD_DIR_CD        = [skd_dir_cd]" ).append("\n"); 
		query.append("--  AND      HDR.POL_CD          = [pol_cd]" ).append("\n"); 
		query.append("--  AND      HDR.POD_CD          = [pod_cd]" ).append("\n"); 
		query.append("--  AND       HDR.ERR_KND_CD             = 'O'" ).append("\n"); 
		query.append("--  " ).append("\n"); 
		query.append("--  AND     HDR.TRSM_BND_CD            = DTL.TRSM_BND_CD" ).append("\n"); 
		query.append("--  AND     HDR.TRSM_DT                = DTL.TRSM_DT" ).append("\n"); 
		query.append("--  AND     HDR.SPCL_CGO_CATE_CD       = DTL.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("--  AND     HDR.PRNR_SPCL_CGO_SEQ      = DTL.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("--  AND     HDR.TRSM_BND_CD            = CNT.TRSM_BND_CD" ).append("\n"); 
		query.append("--  AND     HDR.TRSM_DT                = CNT.TRSM_DT" ).append("\n"); 
		query.append("--  AND     HDR.SPCL_CGO_CATE_CD       = CNT.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("--  AND     HDR.PRNR_SPCL_CGO_SEQ      = CNT.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("--  AND     HDR.PRNR_SPCL_CGO_SEQ      = (  SELECT   MAX(PRNR_SPCL_CGO_SEQ)" ).append("\n"); 
		query.append("--                        FROM   SCG_PRNR_SPCL_CGO_TRSM_HDR   B" ).append("\n"); 
		query.append("--                        WHERE   1 = 1" ).append("\n"); 
		query.append("--                           AND   B.BKG_REF_NO          = HDR.BKG_REF_NO" ).append("\n"); 
		query.append("--                          AND   B.TRSM_BND_CD         = HDR.TRSM_BND_CD" ).append("\n"); 
		query.append("--                           AND   B.TRSM_MZD_CD                = HDR.TRSM_MZD_CD" ).append("\n"); 
		query.append("--                                        AND     B.ERR_KND_CD              = HDR.ERR_KND_CD" ).append("\n"); 
		query.append("--                                        AND     B.CGO_OPR_CD              = HDR.CGO_OPR_CD" ).append("\n"); 
		query.append("--                                        AND     B.VSL_CD                  = HDR.VSL_CD" ).append("\n"); 
		query.append("--                                        AND     B.SKD_VOY_NO              = HDR.SKD_VOY_NO" ).append("\n"); 
		query.append("--                                        AND     B.SKD_DIR_CD              = HDR.SKD_DIR_CD" ).append("\n"); 
		query.append("--                                        AND     B.POL_CD                  = HDR.POL_CD" ).append("\n"); 
		query.append("--                                        AND     B.POD_CD                  = HDR.POD_CD" ).append("\n"); 
		query.append("--                         )" ).append("\n"); 
		query.append("--  AND     DTL.DCGO_REF_NO            = [dcgo_ref_no]" ).append("\n"); 

	}
}