/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtDBDAOmodifyBkgEdiPrnrPortLaneUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.10.09 이일민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ilmin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOmodifyBkgEdiPrnrPortLaneUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBkgEdiPrnrPortLane
	  * </pre>
	  */
	public BookingMasterMgtDBDAOmodifyBkgEdiPrnrPortLaneUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_prnr_sub_lnk_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOmodifyBkgEdiPrnrPortLaneUSQL").append("\n"); 
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
		query.append("UPDATE BKG_EDI_PRNR_PORT_LANE" ).append("\n"); 
		query.append("SET      UPD_USR_ID = NVL(@[upd_usr_id],'SYSTEM'  )" ).append("\n"); 
		query.append(", UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE  TRD_PRNR_SUB_LNK_SEQ = @[trd_prnr_sub_lnk_seq]" ).append("\n"); 
		query.append("AND    SLAN_CD              = @[slan_cd]" ).append("\n"); 

	}
}