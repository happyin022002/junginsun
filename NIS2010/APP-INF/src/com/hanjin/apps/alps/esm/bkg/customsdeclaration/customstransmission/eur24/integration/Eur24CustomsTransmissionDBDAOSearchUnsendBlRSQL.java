/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchUnsendBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOSearchUnsendBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 변경전 VVD로 MRN을 부여 받았지만, VVD변경으로 재 신고해야 할 BL (아직 신고전인 BL)
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchUnsendBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration ").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchUnsendBlRSQL").append("\n"); 
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
		query.append("SELECT BL.BL_NO" ).append("\n"); 
		query.append("       , BL.VSL_CD" ).append("\n"); 
		query.append("       , BL.SKD_VOY_NO " ).append("\n"); 
		query.append("       , BL.SKD_DIR_CD" ).append("\n"); 
		query.append("       , BL.MVMT_REF_NO " ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_BL BL" ).append("\n"); 
		query.append("WHERE BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND BL.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND BL.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND BL.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND BL.CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("AND BL.MSG_SND_NO IS NULL" ).append("\n"); 
		query.append("AND BL.MVMT_REF_NO IS NOT NULL" ).append("\n"); 

	}
}