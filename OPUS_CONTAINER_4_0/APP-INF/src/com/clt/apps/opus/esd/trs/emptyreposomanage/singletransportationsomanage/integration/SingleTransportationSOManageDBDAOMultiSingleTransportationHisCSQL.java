/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOMultiSingleTransportationHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.10.09 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOMultiSingleTransportationHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptyRepo S/O History정보를 입력
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOMultiSingleTransportationHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOMultiSingleTransportationHisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_HIS  (" ).append("\n"); 
		query.append("TRSP_SO_HIS_SEQ                       ," ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD                    ," ).append("\n"); 
		query.append("TRSP_SO_SEQ                           ," ).append("\n"); 
		query.append("FM_NOD_CD                             ," ).append("\n"); 
		query.append("TO_NOD_CD                             ," ).append("\n"); 
		query.append("CRE_OFC_CD                            ," ).append("\n"); 
		query.append("CRE_DT                                ," ).append("\n"); 
		query.append("CRE_USR_ID                            ," ).append("\n"); 
		query.append("UPD_DT								   ," ).append("\n"); 
		query.append("UPD_USR_ID							   ," ).append("\n"); 
		query.append("LOCL_CRE_DT						   ," ).append("\n"); 
		query.append("LOCL_UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("TRS_TRSP_HIS_SEQ1.NEXTVAL			," ).append("\n"); 
		query.append("@[trsp_so_ofc_cty_cd]				," ).append("\n"); 
		query.append("@[trsp_so_seq]						," ).append("\n"); 
		query.append("@[fm_nod_cd]						," ).append("\n"); 
		query.append("@[to_nod_cd]						," ).append("\n"); 
		query.append("@[ctrl_ofc_cd]						," ).append("\n"); 
		query.append("SYSDATE							," ).append("\n"); 
		query.append("@[cre_usr_id] 						," ).append("\n"); 
		query.append("SYSDATE							," ).append("\n"); 
		query.append("@[cre_usr_id] 						," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ctrl_ofc_cd])	," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ctrl_ofc_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}