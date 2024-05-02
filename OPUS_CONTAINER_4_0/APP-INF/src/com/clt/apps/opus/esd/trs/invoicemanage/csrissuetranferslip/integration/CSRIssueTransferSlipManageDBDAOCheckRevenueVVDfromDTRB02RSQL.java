/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCheckRevenueVVDfromDTRB02RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.08.17 김진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCheckRevenueVVDfromDTRB02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 비교02
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCheckRevenueVVDfromDTRB02RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DTRB_COA_VVD_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration ").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCheckRevenueVVDfromDTRB02RSQL").append("\n"); 
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
		query.append("SELECT	VVD_COM_LVL LVL" ).append("\n"); 
		query.append("FROM	AR_MST_REV_VVD" ).append("\n"); 
		query.append("WHERE	VSL_CD				= SUBSTR(@[DTRB_COA_VVD_CD],  1, 4)" ).append("\n"); 
		query.append("AND		SKD_VOY_NO			= SUBSTR(@[DTRB_COA_VVD_CD],  5, 4)" ).append("\n"); 
		query.append("AND		SKD_DIR_CD			= SUBSTR(@[DTRB_COA_VVD_CD],  9, 1)" ).append("\n"); 
		query.append("AND		RLANE_DIR_CD		= SUBSTR(@[DTRB_COA_VVD_CD], 10, 1)" ).append("\n"); 
		query.append("AND		NVL(DELT_FLG, 'N')	= 'N'" ).append("\n"); 

	}
}