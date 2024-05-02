/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsCustomsTransmissionDBDAOaddReceivedLogDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.07.09 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsCustomsTransmissionDBDAOaddReceivedLogDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LOgDEtail Insert
	  * </pre>
	  */
	public RocsCustomsTransmissionDBDAOaddReceivedLogDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usert_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("data_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("varj",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.integration ").append("\n"); 
		query.append("FileName : RocsCustomsTransmissionDBDAOaddReceivedLogDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_RTM_EDI_LOG_DTL" ).append("\n"); 
		query.append("(RCV_SND_DIV_CD," ).append("\n"); 
		query.append("RTM_EDI_MSG_TP_CD," ).append("\n"); 
		query.append("MSG_SND_DT," ).append("\n"); 
		query.append("BL_NO," ).append("\n"); 
		query.append("MSG_SEQ," ).append("\n"); 
		query.append("EDI_SND_MSG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("VALUES ('R'," ).append("\n"); 
		query.append("@[msg_tp]," ).append("\n"); 
		query.append("to_date(@[msg_dt],'yyyymmddhh24miss')," ).append("\n"); 
		query.append("@[bl_no]," ).append("\n"); 
		query.append("@[varj]," ).append("\n"); 
		query.append("@[data_ctnt]," ).append("\n"); 
		query.append("@[usert_id],sysdate,@[usert_id],sysdate)" ).append("\n"); 

	}
}