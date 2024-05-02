/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IsraelCustomsTransmissionDBDAOaddRcvLogErrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.20 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelCustomsTransmissionDBDAOaddRcvLogErrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addRcvLogErr
	  * </pre>
	  */
	public IsraelCustomsTransmissionDBDAOaddRcvLogErrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_err_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_err_ref_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_err_ref_no1",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration ").append("\n"); 
		query.append("FileName : IsraelCustomsTransmissionDBDAOaddRcvLogErrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_EUR_IB_RCV_ERR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    CNT_CD," ).append("\n"); 
		query.append("    EDI_RCV_DT,         EDI_RCV_SEQ,     RCV_LOG_ERR_SEQ, " ).append("\n"); 
		query.append("    CSTMS_ERR_ID,       CSTMS_ERR_MSG,   CSTMS_ERR_REF_NO1,  CSTMS_ERR_REF_NO2," ).append("\n"); 
		query.append("    CRE_USR_ID,         CRE_DT,          UPD_USR_ID,         UPD_DT" ).append("\n"); 
		query.append(") VALUES " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    'IL'," ).append("\n"); 
		query.append("    @[edi_rcv_dt],      @[edi_rcv_seq],    NVL((SELECT MAX(RCV_LOG_ERR_SEQ) FROM BKG_CSTMS_EUR_IB_RCV_ERR WHERE EDI_RCV_DT = @[edi_rcv_dt] AND EDI_RCV_SEQ = @[edi_rcv_seq]),0)+1," ).append("\n"); 
		query.append("    @[cstms_err_id],    @[cstms_err_msg],  @[cstms_err_ref_no1],  @[cstms_err_ref_no2]," ).append("\n"); 
		query.append("    @[cre_usr_id],      SYSDATE,           @[cre_usr_id],         SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}