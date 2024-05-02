/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCustomsTransmissionDBDAOcheckIfAcptCuscarExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.06.30 정재엽
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.interation ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsCustomsTransmissionDBDAOcheckIfAcptCuscarExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public AncsCustomsTransmissionDBDAOcheckIfAcptCuscarExistRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT BL.VSL_CD, BL.SKD_VOY_NO, BL.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_BL BL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BL.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND BL.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND BL.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT CNTR.VSL_CD, CNTR.SKD_VOY_NO, CNTR.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_CNTR CNTR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CNTR.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND CNTR.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND CNTR.SKD_DIR_CD = @[skd_dir_cd] )" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.customstransmission.ancs.interation ").append("\n"); 
		query.append("FileName : AncsCustomsTransmissionDBDAOcheckIfAcptCuscarExistRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}