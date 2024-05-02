/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOBkgCodCostVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOBkgCodCostVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOBkgCodCostVORSQL(){
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
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOBkgCodCostVORSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(",      COD_RQST_SEQ" ).append("\n"); 
		query.append(",      CHG_CD" ).append("\n"); 
		query.append(",      CURR_CD" ).append("\n"); 
		query.append(",      CHG_UT_AMT" ).append("\n"); 
		query.append(",      RAT_UT_CD" ).append("\n"); 
		query.append(",      RAT_AS_QTY" ).append("\n"); 
		query.append(",      CHG_AMT" ).append("\n"); 
		query.append(",      CGO_CATE_CD" ).append("\n"); 
		query.append(",      COST_CD_RQST_SEQ" ).append("\n"); 
		query.append(",      CNTR_CGO_TP_CD" ).append("\n"); 
		query.append(",      COD_RHND_PORT_YD_CD" ).append("\n"); 
		query.append("FROM BKG_COD_COST" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND COD_RQST_SEQ = @[cod_rqst_seq]" ).append("\n"); 
		query.append("ORDER BY COST_CD_RQST_SEQ" ).append("\n"); 

	}
}