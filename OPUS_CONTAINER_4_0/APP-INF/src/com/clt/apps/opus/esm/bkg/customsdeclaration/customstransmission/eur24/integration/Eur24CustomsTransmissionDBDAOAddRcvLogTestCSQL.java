/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOAddRcvLogTestCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOAddRcvLogTestCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOAddRcvLogTest
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOAddRcvLogTestCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_msg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration ").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOAddRcvLogTestCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ADV_EUR_RCV" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    EDI_RCV_DT,         EDI_RCV_SEQ, " ).append("\n"); 
		query.append("    EDI_RCV_MSG_CTNT," ).append("\n"); 
		query.append("    CRE_USR_ID,         CRE_DT,          UPD_USR_ID,      UPD_DT," ).append("\n"); 
		query.append("    RCV_TMS" ).append("\n"); 
		query.append(") VALUES " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    @[edi_rcv_dt],         @[edi_rcv_seq]," ).append("\n"); 
		query.append("    @[edi_rcv_msg_ctnt]," ).append("\n"); 
		query.append("    @[cre_usr_id],         SYSDATE,            @[cre_usr_id],      SYSDATE," ).append("\n"); 
		query.append("    CURRENT_TIMESTAMP" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}