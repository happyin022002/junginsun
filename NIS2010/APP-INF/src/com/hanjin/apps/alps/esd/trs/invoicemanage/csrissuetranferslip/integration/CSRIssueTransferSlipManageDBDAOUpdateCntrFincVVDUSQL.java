/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOUpdateCntrFincVVDUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.19
*@LastModifier : YOO Sunoh
*@LastVersion : 1.0
* 2011.10.19 YOO Sunoh
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOO Sunoh
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOUpdateCntrFincVVDUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNTR VVD를 업데이트한다
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOUpdateCntrFincVVDUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("AP_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOUpdateCntrFincVVDUSQL").append("\n"); 
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
		query.append("UPDATE    	TRS_TRSP_SVC_ORD X" ).append("\n"); 
		query.append("SET         X.FINC_VVD_CD =" ).append("\n"); 
		query.append("NVL(	TRS_COMMON_PKG.GET_BKG_REV_VVD3_FNC(    @[AP_OFC_CD]" ).append("\n"); 
		query.append(",   @[INV_DT]" ).append("\n"); 
		query.append(",   X.TRSP_SO_TP_CD" ).append("\n"); 
		query.append(",	X.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",	X.TRSP_SO_SEQ" ).append("\n"); 
		query.append(",	X.EQ_KND_CD" ).append("\n"); 
		query.append(",	X.CGO_TP_CD" ).append("\n"); 
		query.append(",	X.ORG_BKG_NO" ).append("\n"); 
		query.append(",	X.REF_BKG_NO" ).append("\n"); 
		query.append(",	X.VSL_CD" ).append("\n"); 
		query.append(",	X.SKD_VOY_NO" ).append("\n"); 
		query.append(",	X.SKD_DIR_CD" ).append("\n"); 
		query.append(",	X.TRSP_OTR_COST_MON_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",	'CNTC'||SUBSTR(TRS_GET_GL_DT_FNC( '', @[AP_OFC_CD], @[INV_DT], '15'),3,4)||'MM'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE   X.INV_VNDR_SEQ    		= @[INV_VNDR_SEQ]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($INV_NO.size() > 0)" ).append("\n"); 
		query.append("AND	X.INV_NO	IN	(" ).append("\n"); 
		query.append("#foreach( ${key} in ${INV_NO})" ).append("\n"); 
		query.append("#if($velocityCount < $INV_NO.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}