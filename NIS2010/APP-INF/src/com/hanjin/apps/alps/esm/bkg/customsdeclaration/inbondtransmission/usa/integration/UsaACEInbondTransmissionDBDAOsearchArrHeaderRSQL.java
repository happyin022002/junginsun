/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UsaACEInbondTransmissionDBDAOsearchArrHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaACEInbondTransmissionDBDAOsearchArrHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaACEInbondTransmissionDBDAOsearchArrHeaderRSQL
	  * </pre>
	  */
	public UsaACEInbondTransmissionDBDAOsearchArrHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lloyd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tmpstr4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_flag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaACEInbondTransmissionDBDAOsearchArrHeaderRSQL").append("\n"); 
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
		query.append("	'//PACMFSML  JOB  (IC17,2318),'||'''SMLINE'''||',MSGCLASS=D,CLASS=X,                       '||CHR(10)||" ).append("\n"); 
		query.append("	'//  USER=R7770                                                                  '||CHR(10)||" ).append("\n"); 
		query.append("	'/*ROUTE PRINT LOCAL                                                             '||CHR(10)||" ).append("\n"); 
		query.append("	'/*ROUTE PUNCH LOCAL                                                             '||CHR(10)||" ).append("\n"); 
		query.append("	'//STEP1 EXEC  AMSPR02                                                           '||CHR(10)||" ).append("\n"); 
		query.append("	'//MA7010.INFILE DD  *                                                           '||CHR(10)||" ).append("\n"); 
		query.append("	RPAD('ACRSMLMSML911HI',80,' ')||CHR(10)||" ).append("\n"); 
		query.append("	RPAD('M01SMLM11'||" ).append("\n"); 
		query.append("	RPAD(@[vsl_flag],2,' ')||" ).append("\n"); 
		query.append("	RPAD(@[vsl_eng_nm],23,' ')||LPAD(SUBSTR(@[vvd],5,5),5,'0')||" ).append("\n"); 
		query.append("	  LPAD(TO_CHAR(@[bl_cnt]),5,'0')||'      Y'||@[vsl_lloyd],80,' ')||CHR(10)||" ).append("\n"); 
		query.append("    RPAD('M02'||@[crr_bat_no], 80, ' ')||CHR(10) ||" ).append("\n"); 
		query.append("	RPAD('P01'||RPAD(@[tmpstr4],4,' ')||RPAD(@[vps_eta_dt],6,' ')||" ).append("\n"); 
		query.append("	  LPAD(TO_CHAR(@[bl_cnt]),5,'0'),80,' ')||CHR(10)" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}