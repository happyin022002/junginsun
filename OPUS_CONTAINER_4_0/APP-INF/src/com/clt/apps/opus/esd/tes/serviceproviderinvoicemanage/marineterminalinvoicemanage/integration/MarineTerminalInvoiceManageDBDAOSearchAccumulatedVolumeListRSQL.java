/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchAccumulatedVolumeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.12.08 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchAccumulatedVolumeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAccumulatedVolumeList
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchAccumulatedVolumeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration ").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchAccumulatedVolumeListRSQL").append("\n"); 
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
		query.append("SELECT M.TML_ACCM_UT_CD," ).append("\n"); 
		query.append("M.ACCM_FM_DT," ).append("\n"); 
		query.append("M.ACCM_TO_DT," ).append("\n"); 
		query.append("A.PAY_VOL_QTY," ).append("\n"); 
		query.append("M.VNDR_SEQ," ).append("\n"); 
		query.append("M.ACCM_SEQ" ).append("\n"); 
		query.append("FROM   TES_TML_SO_ACCM_MZD M, TES_TML_SO_ACCM_YD Y, TES_TML_SO_ACCM A" ).append("\n"); 
		query.append("WHERE  M.VNDR_SEQ   = @[vndr_seq]" ).append("\n"); 
		query.append("AND    M.VNDR_SEQ   = Y.VNDR_SEQ" ).append("\n"); 
		query.append("AND    M.ACCM_SEQ   = Y.ACCM_SEQ" ).append("\n"); 
		query.append("AND    Y.YD_CD      = @[yd_cd]" ).append("\n"); 
		query.append("AND    M.VNDR_SEQ   = A.VNDR_SEQ" ).append("\n"); 
		query.append("AND    M.ACCM_SEQ   = A.ACCM_SEQ" ).append("\n"); 

	}
}