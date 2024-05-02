/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationBLDBDAOSearchMtyCntrCycRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.22
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.22 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOSearchMtyCntrCycRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Cycle No를 조회한다.
	  * </pre>
	  */
	public BLDocumentationBLDBDAOSearchMtyCntrCycRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOSearchMtyCntrCycRSQL").append("\n"); 
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
		query.append("SELECT nvl(cntr.cnmv_cyc_no, 0) cnmv_cyc_no" ).append("\n"); 
		query.append(", nvl(cntr.CNMV_ID_NO, 0) CNMV_ID_NO" ).append("\n"); 
		query.append(", nvl(cntr.CNMV_YR, ' ') CNMV_YR" ).append("\n"); 
		query.append(", nvl(cntr.CNMV_STS_CD, ' ') CNMV_STS_CD" ).append("\n"); 
		query.append(", nvl(cntr.ORG_FM_LOC_CD, ' ') ORG_FM_LOC_CD" ).append("\n"); 
		query.append("FROM  bkg_booking BK, bkg_container cntr" ).append("\n"); 
		query.append("WHERE BK.bkg_no               = @[bkg_no]" ).append("\n"); 
		query.append("AND   NVL(BK.bkg_sts_cd, ' ') <> 'S'" ).append("\n"); 
		query.append("AND   BK.bkg_no 		      = cntr.bkg_no" ).append("\n"); 
		query.append("AND   cntr.cntr_no            = @[cntr_no]" ).append("\n"); 

	}
}