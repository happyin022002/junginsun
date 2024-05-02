/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PreDispatchSentHistoryDBDAOSearchServiceOrderManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.11.02 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreDispatchSentHistoryDBDAOSearchServiceOrderManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PreDispatchSentHistoryDBDAOSearchServiceOrderManageRSQL
	  * </pre>
	  */
	public PreDispatchSentHistoryDBDAOSearchServiceOrderManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.integration").append("\n"); 
		query.append("FileName : PreDispatchSentHistoryDBDAOSearchServiceOrderManageRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", TRSP_SO_SEQ" ).append("\n"); 
		query.append("FROM     TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE    EQ_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND      BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND      FM_NOD_CD = @[pkup_yd_cd]" ).append("\n"); 

	}
}