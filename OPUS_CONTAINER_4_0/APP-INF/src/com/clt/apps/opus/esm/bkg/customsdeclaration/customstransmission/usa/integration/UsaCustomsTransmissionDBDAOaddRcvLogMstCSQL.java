/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOaddRcvLogMstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.29
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.04.29 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOaddRcvLogMstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOaddRcvLogMstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ir_batch_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ir_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ir_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ir_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_bat_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_snp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOaddRcvLogMstCSQL").append("\n"); 
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
		query.append("INSERT " ).append("\n"); 
		query.append("  INTO BKG_CSTMS_ADV_RCV_LOG" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       CNT_CD" ).append("\n"); 
		query.append("      ,IO_BND_CD" ).append("\n"); 
		query.append("      ,RCV_DT,RCV_SEQ" ).append("\n"); 
		query.append("      ,RCV_MSG_TP_ID" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,CSTMS_BAT_NO" ).append("\n"); 
		query.append("      ,CRR_BAT_NO" ).append("\n"); 
		query.append("      ,SCAC_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       'US'" ).append("\n"); 
		query.append("      ,'I'" ).append("\n"); 
		query.append("      ,TO_DATE(@[ir_date],'RRMMDDHH24MISS')" ).append("\n"); 
		query.append("      ,@[ir_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${is_baplie_rc} == 'Y') " ).append("\n"); 
		query.append("	  , 'RB'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("      ,@[ir_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,@[vsl_cd]" ).append("\n"); 
		query.append("      ,@[skd_voy_no]" ).append("\n"); 
		query.append("      ,@[skd_dir_cd]" ).append("\n"); 
		query.append("      ,@[pod_loc]" ).append("\n"); 
		query.append("      ,@[pol_cd]" ).append("\n"); 
		query.append("      ,@[ir_batch_no]" ).append("\n"); 
		query.append("      ,@[crr_bat_no]" ).append("\n"); 
		query.append("      ,@[in_snp]" ).append("\n"); 
		query.append("      ,'SYSTEM'" ).append("\n"); 
		query.append("      ,'SYSTEM'" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}