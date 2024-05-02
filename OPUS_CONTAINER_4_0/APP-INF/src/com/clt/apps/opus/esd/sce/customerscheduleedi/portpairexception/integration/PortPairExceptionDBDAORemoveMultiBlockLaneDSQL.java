/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairExceptionDBDAORemoveMultiBlockLaneDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.03.29 함대성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairExceptionDBDAORemoveMultiBlockLaneDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PortPairExceptionDBDAORemoveMultiBlockLaneDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAORemoveMultiBlockLaneDSQL").append("\n"); 
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
		query.append("UPDATE  SCE_CUST_EDI_BLCK" ).append("\n"); 
		query.append("SET (DELT_FLG, UPD_USR_ID, UPD_DT) = (SELECT 'Y', @[upd_usr_id], SYSDATE FROM DUAL)" ).append("\n"); 
		query.append("WHERE (ROUT_RCV_DT, ROUT_SEQ, BLCK_SEQ) IN (SELECT S.ROUT_RCV_DT, S.ROUT_SEQ, B.BLCK_SEQ" ).append("\n"); 
		query.append("FROM SCE_PORT_PAIR_DTL S, SCE_CUST_EDI_BLCK B" ).append("\n"); 
		query.append("WHERE S.ROUT_RCV_DT = B.ROUT_RCV_DT" ).append("\n"); 
		query.append("AND S.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("AND S.CUST_TRD_PRNR_ID = @[cust_trd_prnr_id]" ).append("\n"); 
		query.append("AND S.ORG_LOC_CD = @[pol_cd]" ).append("\n"); 
		query.append("AND S.DEST_LOC_CD = @[pod_cd]" ).append("\n"); 
		query.append("AND B.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}