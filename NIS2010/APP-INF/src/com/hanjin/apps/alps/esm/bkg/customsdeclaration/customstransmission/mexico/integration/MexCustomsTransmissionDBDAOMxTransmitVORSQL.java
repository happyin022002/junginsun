/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOMxTransmitVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.21 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOMxTransmitVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MxTransmitVO 생성용
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOMxTransmitVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mex.integration ").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOMxTransmitVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' bkg_no" ).append("\n"); 
		query.append(",'' pol_cd" ).append("\n"); 
		query.append(",'' pod_cd" ).append("\n"); 
		query.append(",'' vvd" ).append("\n"); 
		query.append(",'' cntr_no" ).append("\n"); 
		query.append(",'' bl_no" ).append("\n"); 
		query.append(",'' his_seq" ).append("\n"); 
		query.append(",'' ntc_knd_cd" ).append("\n"); 
		query.append(",'' edi_id" ).append("\n"); 
		query.append(",'' bkg_ntc_snd_rslt_cd" ).append("\n"); 
		query.append(",'' snd_usr_id" ).append("\n"); 
		query.append(",'' cre_usr_id" ).append("\n"); 
		query.append(",'' upd_usr_id" ).append("\n"); 
		query.append(",'' tmp1" ).append("\n"); 
		query.append(",'' tmp2" ).append("\n"); 
		query.append(",'' tmp3" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}