/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InterfaceMgtDBDAOmodifyESTTmpDTLLastVersionUnFlagDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOmodifyESTTmpDTLLastVersionUnFlagDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyESTTmpDTLLastVersionUnFlagData
	  * </pre>
	  */
	public InterfaceMgtDBDAOmodifyESTTmpDTLLastVersionUnFlagDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rpr_rqst_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOmodifyESTTmpDTLLastVersionUnFlagDataUSQL").append("\n"); 
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
		query.append("UPDATE   MNR_RPR_RQST_TMP_DTL A" ).append("\n"); 
		query.append("SET      A.RPR_RQST_LST_VER_FLG = 'N'" ).append("\n"); 
		query.append("       , A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("       , A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("AND      A.RPR_RQST_TMP_SEQ = @[rpr_rqst_tmp_seq]" ).append("\n"); 

	}
}