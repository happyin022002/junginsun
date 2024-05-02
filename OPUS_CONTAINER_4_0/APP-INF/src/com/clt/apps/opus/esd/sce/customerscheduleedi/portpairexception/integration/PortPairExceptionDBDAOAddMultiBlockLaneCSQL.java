/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortPairExceptionDBDAOAddMultiBlockLaneCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.03.05 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairExceptionDBDAOAddMultiBlockLaneCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PortPairExceptionDBDAOAddMultiBlockLaneCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAOAddMultiBlockLaneCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_CUST_EDI_BLCK" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	ROUT_RCV_DT ," ).append("\n"); 
		query.append("	ROUT_SEQ    ," ).append("\n"); 
		query.append("	BLCK_SEQ    ," ).append("\n"); 
		query.append("	SLAN_CD     ," ).append("\n"); 
		query.append("	DELT_FLG    ," ).append("\n"); 
		query.append("	CRE_USR_ID  ," ).append("\n"); 
		query.append("	CRE_DT      ," ).append("\n"); 
		query.append("	UPD_USR_ID  ," ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT ROUT_RCV_DT, ROUT_SEQ, (SELECT NVL(MAX(B.BLCK_SEQ),0)" ).append("\n"); 
		query.append("                                 FROM SCE_PORT_PAIR_DTL S, SCE_CUST_EDI_BLCK B" ).append("\n"); 
		query.append("                                WHERE S.ROUT_RCV_DT = B.ROUT_RCV_DT" ).append("\n"); 
		query.append("                                  AND S.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("                                  AND S.CUST_TRD_PRNR_ID = @[cust_trd_prnr_id]" ).append("\n"); 
		query.append("                                  AND S.ORG_LOC_CD = @[pol_cd]" ).append("\n"); 
		query.append("                                  AND S.DEST_LOC_CD = @[pod_cd]" ).append("\n"); 
		query.append("                                )+rownum, " ).append("\n"); 
		query.append("       @[slan_cd], 'N', @[cre_usr_id], SYSDATE, @[upd_usr_id], SYSDATE" ).append("\n"); 
		query.append("FROM SCE_PORT_PAIR_DTL SPR" ).append("\n"); 
		query.append("WHERE SPR.CUST_TRD_PRNR_ID = @[cust_trd_prnr_id]" ).append("\n"); 
		query.append("AND SPR.ORG_LOC_CD = @[pol_cd]" ).append("\n"); 
		query.append("AND SPR.DEST_LOC_CD = @[pod_cd]" ).append("\n"); 

	}
}