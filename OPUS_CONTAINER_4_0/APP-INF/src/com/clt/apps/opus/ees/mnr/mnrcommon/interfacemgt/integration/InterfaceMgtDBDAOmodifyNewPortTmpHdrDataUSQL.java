/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceMgtDBDAOmodifyNewPortTmpHdrDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOmodifyNewPortTmpHdrDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public InterfaceMgtDBDAOmodifyNewPortTmpHdrDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_rcv_ord_inv_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vrfy_rslt_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration ").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOmodifyNewPortTmpHdrDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_ORD_TMP_HDR" ).append("\n"); 
		query.append("   SET VRFY_RSLT_DESC = @[vrfy_rslt_desc]" ).append("\n"); 
		query.append("      ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE MNR_RCV_ORD_INV_TMP_SEQ = @[mnr_rcv_ord_inv_tmp_seq]" ).append("\n"); 

	}
}