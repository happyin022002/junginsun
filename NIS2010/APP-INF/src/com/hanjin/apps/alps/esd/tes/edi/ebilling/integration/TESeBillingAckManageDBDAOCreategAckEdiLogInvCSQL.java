/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TESeBillingAckManageDBDAOCreategAckEdiLogInvCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingAckManageDBDAOCreategAckEdiLogInvCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACK EDI LOG 정보 넣기
	  * </pre>
	  */
	public TESeBillingAckManageDBDAOCreategAckEdiLogInvCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_log_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration").append("\n"); 
		query.append("FileName : TESeBillingAckManageDBDAOCreategAckEdiLogInvCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_EDI_ACK_SND_LOG_INV (" ).append("\n"); 
		query.append("EDI_SND_DT" ).append("\n"); 
		query.append(", SND_LOG_SEQ" ).append("\n"); 
		query.append(", TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", TML_EDI_SO_SEQ" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[edi_snd_dt]" ).append("\n"); 
		query.append(", @[snd_log_seq]" ).append("\n"); 
		query.append(", @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append(", @[tml_edi_so_seq]" ).append("\n"); 
		query.append(", 'ALPS_TES'" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", 'ALPS_TES'" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}