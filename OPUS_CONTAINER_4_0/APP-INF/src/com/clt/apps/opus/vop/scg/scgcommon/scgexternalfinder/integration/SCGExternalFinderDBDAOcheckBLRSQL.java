/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGExternalFinderDBDAOcheckBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.09 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGExternalFinderDBDAOcheckBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking 정보 조회
	  * </pre>
	  */
	public SCGExternalFinderDBDAOcheckBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.integration").append("\n"); 
		query.append("FileName : SCGExternalFinderDBDAOcheckBLRSQL").append("\n"); 
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
		query.append("BK.SPLIT_FLG" ).append("\n"); 
		query.append(",	BK.BKG_NO" ).append("\n"); 
		query.append(",	BK.BKG_NO_SPLIT" ).append("\n"); 
		query.append(",	BK.BL_NO" ).append("\n"); 
		query.append(",	BK.POR_CD" ).append("\n"); 
		query.append(",	BK.POL_CD" ).append("\n"); 
		query.append(",	BK.POD_CD" ).append("\n"); 
		query.append(",	BK.DEL_CD" ).append("\n"); 
		query.append(",   SH.CUST_NM S_CUST_NM" ).append("\n"); 
		query.append(",   FF.CUST_NM F_CUST_NM" ).append("\n"); 
		query.append(",   CN.CUST_NM C_CUST_NM" ).append("\n"); 
		query.append("FROM BKG_BOOKING  BK" ).append("\n"); 
		query.append(", BKG_CUSTOMER SH" ).append("\n"); 
		query.append(", BKG_CUSTOMER FF" ).append("\n"); 
		query.append(", BKG_CUSTOMER CN" ).append("\n"); 
		query.append("WHERE BK.BL_NO        = @[bl_no]" ).append("\n"); 
		query.append("AND BK.BKG_NO         = SH.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO_SPLIT   = SH.BKG_NO_SPLIT" ).append("\n"); 
		query.append("AND SH.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND BK.BKG_NO         = FF.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO_SPLIT   = FF.BKG_NO_SPLIT" ).append("\n"); 
		query.append("AND FF.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("AND BK.BKG_NO         = CN.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO_SPLIT   = CN.BKG_NO_SPLIT" ).append("\n"); 
		query.append("AND CN.BKG_CUST_TP_CD = 'C'" ).append("\n"); 

	}
}