/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalMgtDBDAOremoveDisposalBuyerHRDDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.09.11 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOremoveDisposalBuyerHRDDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removeDisposalBuyerHRDData
	  * </pre>
	  */
	public DisposalMgtDBDAOremoveDisposalBuyerHRDDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration ").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOremoveDisposalBuyerHRDDataDSQL").append("\n"); 
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
		query.append("DELETE FROM MNR_DISP_BUYR_PART A" ).append("\n"); 
		query.append("WHERE DISP_NO = @[disp_no]" ).append("\n"); 

	}
}