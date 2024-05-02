/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UsaACECustomsTransmissionDBDAOsearchMiHiHeaderFooterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaACECustomsTransmissionDBDAOsearchMiHiHeaderFooterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaACECustomsTransmissionDBDAOsearchMiHiHeaderFooterRSQL
	  * </pre>
	  */
	public UsaACECustomsTransmissionDBDAOsearchMiHiHeaderFooterRSQL(){
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
		params.put("loc_amsport",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_flag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaACECustomsTransmissionDBDAOsearchMiHiHeaderFooterRSQL").append("\n"); 
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
		query.append("     '//PACMFSML  JOB  (IC17,2318),'||'''SMLINE'''||',MSGCLASS=D,CLASS=X,                       '||CHR(10)||" ).append("\n"); 
		query.append("     '//  USER=R7770                                                                  '||CHR(10)||" ).append("\n"); 
		query.append("     '/*ROUTE PRINT LOCAL                                                             '||CHR(10)||" ).append("\n"); 
		query.append("     '/*ROUTE PUNCH LOCAL                                                             '||CHR(10)||" ).append("\n"); 
		query.append("     '//STEP1 EXEC  AMSPR02                                                           '||CHR(10)||" ).append("\n"); 
		query.append("     '//MA7010.INFILE DD  *                                                           '||CHR(10)||" ).append("\n"); 
		query.append("     RPAD('ACRSMLM      '||@[trsp_msg_tp_cd]||" ).append("\n"); 
		query.append("          TO_CHAR(TO_DATE(@[snd_dt], 'ddmmrrhh24miss'),'yymmdd')||" ).append("\n"); 
		query.append("          TO_CHAR(TO_DATE(@[snd_dt], 'ddmmrrhh24miss'),'hh24miss')" ).append("\n"); 
		query.append("          ,80,' ')||CHR(10)||" ).append("\n"); 
		query.append("     RPAD('M01SMLM11'||substr(@[vsl_flag],1,2)||" ).append("\n"); 
		query.append("	 RPAD(' ', 23, ' ')||substr(@[vvd],5,5)||" ).append("\n"); 
		query.append("	 LPAD(TO_CHAR('     '),5,'0')||'      '||' '||@[vsl_lloyd],80,' ')||CHR(10)||		  " ).append("\n"); 
		query.append("	 RPAD('M02'||@[crr_bat_no], 80, ' ')||CHR(10) ||" ).append("\n"); 
		query.append("#if (${trsp_msg_tp_cd} == 'HI') " ).append("\n"); 
		query.append("     RPAD('P01'||substr(@[loc_amsport],1,4)||substr(@[vps_eta_dt],1,6)||LPAD(TO_CHAR(' '),5,' '),80,' ')||CHR(10) HEADER," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     RPAD('P01'||substr(@[loc_amsport],1,4)||substr(@[vps_eta_dt],1,6)||LPAD(TO_CHAR(' '),5,' '),80,' ')||CHR(10)||" ).append("\n"); 
		query.append("     RPAD('J01SMLM',80,' ')||CHR(10) HEADER," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     RPAD('ZCRSMLM',80,' ')||CHR(10)||" ).append("\n"); 
		query.append("      '/*                                                                              ' FOOTER" ).append("\n"); 
		query.append("FROM DUAL " ).append("\n"); 

	}
}