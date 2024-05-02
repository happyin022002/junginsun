/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortRestrictionDBDAOExeSaveAsDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.04 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortRestrictionDBDAOExeSaveAsDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PortRestrictionDBDAOExeSaveAsDtlCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_port_rstr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_imdg_port_rstr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO  SCG_IMDG_PORT_RSTR_DTL" ).append("\n"); 
		query.append("(PORT_CD                  ," ).append("\n"); 
		query.append("IMDG_PORT_RSTR_SEQ       ," ).append("\n"); 
		query.append("PORT_PROHI_TP_CD         ," ).append("\n"); 
		query.append("IMDG_CMPTN_AUTH_CD       ," ).append("\n"); 
		query.append("TON_OVR_VOL_QTY          ," ).append("\n"); 
		query.append("ND_TM_HRS                ," ).append("\n"); 
		query.append("TML_MAX_QTY              ," ).append("\n"); 
		query.append("OBRD_MAX_QTY             ," ).append("\n"); 
		query.append("ONE_TM_HNDL_MAX_QTY      ," ).append("\n"); 
		query.append("DYS_STO_FLG              ," ).append("\n"); 
		query.append("STO_DYS                  ," ).append("\n"); 
		query.append("PROHI_DESC               ," ).append("\n"); 
		query.append("TXT_DESC                 ," ).append("\n"); 
		query.append("CRE_USR_ID               ," ).append("\n"); 
		query.append("CRE_DT                   ," ).append("\n"); 
		query.append("UPD_USR_ID               ," ).append("\n"); 
		query.append("UPD_DT                    )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[new_port_cd]PORT_CD                  ," ).append("\n"); 
		query.append("@[new_imdg_port_rstr_seq]IMDG_PORT_RSTR_SEQ       ," ).append("\n"); 
		query.append("PORT_PROHI_TP_CD         ," ).append("\n"); 
		query.append("IMDG_CMPTN_AUTH_CD       ," ).append("\n"); 
		query.append("TON_OVR_VOL_QTY          ," ).append("\n"); 
		query.append("ND_TM_HRS                ," ).append("\n"); 
		query.append("TML_MAX_QTY              ," ).append("\n"); 
		query.append("OBRD_MAX_QTY             ," ).append("\n"); 
		query.append("ONE_TM_HNDL_MAX_QTY      ," ).append("\n"); 
		query.append("DYS_STO_FLG              ," ).append("\n"); 
		query.append("STO_DYS                  ," ).append("\n"); 
		query.append("PROHI_DESC               ," ).append("\n"); 
		query.append("TXT_DESC                 ," ).append("\n"); 
		query.append("@[cre_usr_id]               ," ).append("\n"); 
		query.append("SYSDATE                   ," ).append("\n"); 
		query.append("@[cre_usr_id]                ," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM SCG_IMDG_PORT_RSTR_DTL" ).append("\n"); 
		query.append("WHERE PORT_CD = @[port_cd] AND  IMDG_PORT_RSTR_SEQ= @[imdg_port_rstr_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration").append("\n"); 
		query.append("FileName : PortRestrictionDBDAOExeSaveAsDtlCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}