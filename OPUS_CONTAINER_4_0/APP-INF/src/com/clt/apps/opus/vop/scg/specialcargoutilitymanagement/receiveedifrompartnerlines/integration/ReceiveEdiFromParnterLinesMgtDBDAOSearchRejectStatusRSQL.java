/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOSearchRejectStatusRSQL.java
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

public class ReceiveEdiFromParnterLinesMgtDBDAOSearchRejectStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOSearchRejectStatusRSQL(){
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
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOSearchRejectStatusRSQL").append("\n"); 
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
		query.append("SELECT  A.EDI_MSG_STS_CD" ).append("\n"); 
		query.append("FROM    SCG_PRNR_SPCL_CGO_TRSM_HDR	A" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     A.TRSM_MZD_CD               = 'EDI'                          --::EDI, EML::--" ).append("\n"); 
		query.append("AND     A.BKG_REF_NO          		= @[bkg_ref_no]" ).append("\n"); 
		query.append("AND     A.TRSM_BND_CD         		= @[trsm_bnd_cd]" ).append("\n"); 
		query.append("AND     A.CGO_OPR_CD          		= @[cgo_opr_cd]" ).append("\n"); 
		query.append("AND     A.VSL_CD              		= @[vsl_cd]" ).append("\n"); 
		query.append("AND     A.SKD_VOY_NO          		= @[skd_voy_no]" ).append("\n"); 
		query.append("AND     A.SKD_DIR_CD          		= @[skd_dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("----AND     A.POL_CD              		= NVL([pol_cd],A.POL_CD)" ).append("\n"); 
		query.append("----AND     A.POD_CD              		= NVL([pod_cd],A.POD_CD)	/* Empty in case of cancellation EDI */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     A.ERR_KND_CD          		= 'O'" ).append("\n"); 
		query.append("AND     A.PRNR_SPCL_CGO_SEQ       	= ( SELECT	MAX(PRNR_SPCL_CGO_SEQ)" ).append("\n"); 
		query.append("                                       	FROM   	SCG_PRNR_SPCL_CGO_TRSM_HDR	B" ).append("\n"); 
		query.append("                                		WHERE   1 = 1" ).append("\n"); 
		query.append("                                		AND   	B.TRSM_MZD_CD               = A.TRSM_MZD_CD" ).append("\n"); 
		query.append("                                		AND   	B.BKG_REF_NO          		= A.BKG_REF_NO" ).append("\n"); 
		query.append("                                		AND   	B.TRSM_BND_CD         		= A.TRSM_BND_CD" ).append("\n"); 
		query.append("                                		AND   	B.ERR_KND_CD          		= A.ERR_KND_CD" ).append("\n"); 
		query.append("                                		AND   	B.CGO_OPR_CD          		= A.CGO_OPR_CD" ).append("\n"); 
		query.append("                                		AND   	B.VSL_CD              		= A.VSL_CD" ).append("\n"); 
		query.append("                                		AND   	B.SKD_VOY_NO          		= A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                		AND   	B.SKD_DIR_CD          		= A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                		----AND   	B.POL_CD              		= A.POL_CD" ).append("\n"); 
		query.append("                                		----AND   	B.POD_CD              		= A.POD_CD" ).append("\n"); 
		query.append("                               			)" ).append("\n"); 

	}
}