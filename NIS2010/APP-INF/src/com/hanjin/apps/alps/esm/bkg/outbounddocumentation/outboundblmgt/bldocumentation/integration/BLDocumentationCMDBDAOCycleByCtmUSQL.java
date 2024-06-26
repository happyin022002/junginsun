/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCycleByCtmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.07 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCycleByCtmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCycleByCtmUSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCycleByCtmUSQL").append("\n"); 
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
		query.append("UPDATE  BKG_CONTAINER" ).append("\n"); 
		query.append("SET     CNMV_CYC_NO   = 9999," ).append("\n"); 
		query.append("CNMV_STS_CD   = 'MT'," ).append("\n"); 
		query.append("CNMV_EVNT_DT  = TO_DATE(@[cnmv_evnt_dt], 'ddMonrr hh24:mi')," ).append("\n"); 
		query.append("DIFF_RMK      = 'MT repo VL deleted'" ).append("\n"); 
		query.append("WHERE   BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND     CNTR_NO       = @[cntr_no]" ).append("\n"); 
		query.append("AND     (CNMV_CYC_NO  = @[cnmv_cyc_no] OR CNMV_CYC_NO  = 9999)" ).append("\n"); 

	}
}