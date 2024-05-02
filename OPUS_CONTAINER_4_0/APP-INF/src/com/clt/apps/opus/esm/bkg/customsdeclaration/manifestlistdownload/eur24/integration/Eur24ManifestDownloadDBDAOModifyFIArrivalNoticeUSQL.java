/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOModifyFIArrivalNoticeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.07
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2014.01.07 조원주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOModifyFIArrivalNoticeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyFIArrivalNotice
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOModifyFIArrivalNoticeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvy_ref_no_hidden",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_net_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOModifyFIArrivalNoticeUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_EUR_VSL " ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("	PORT_NET_NO = @[port_net_no]," ).append("\n"); 
		query.append("	UPD_OFC_CD = (SELECT OFC_CD FROM COM_USER WHERE USR_ID = @[upd_usr_id])" ).append("\n"); 
		query.append("WHERE 1 = 1 " ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("  AND VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("  AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("  AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("  AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cvy_ref_no_hidden} != '')" ).append("\n"); 
		query.append("  AND CVY_REF_NO = @[cvy_ref_no_hidden]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}