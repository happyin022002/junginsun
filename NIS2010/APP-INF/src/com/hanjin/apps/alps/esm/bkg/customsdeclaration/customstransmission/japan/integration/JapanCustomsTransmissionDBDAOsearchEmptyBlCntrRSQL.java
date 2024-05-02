/*=========================================================
*Copyright(c) 2017 HI-Plus Card
*@FileName : JapanCustomsTransmissionDBDAOsearchEmptyBlCntrRSQL.java
*@FileTitle : JapanCustomsTransmissionDBDAOsearchEmptyBlCntrRSQL
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.16
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2017.08.16 하대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsTransmissionDBDAOsearchEmptyBlCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEmptyBlCntr
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchEmptyBlCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchEmptyBlCntrRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	RPAD(CNTR_NO,12,' ') CNTR_NO, --93.Container Number 				" ).append("\n"); 
		query.append("	RPAD(NVL(CNTR_SEAL_NO,' '),15,' ') CNTR_SEAL_NO, --94.Seal Number(1중복)" ).append("\n"); 
		query.append("	--RPAD(' ',15,' ') DATA1, --75 Seal No.  						" ).append("\n"); 
		query.append("	--RPAD(' ',15,' ') DATA2, --75 Seal No.  						" ).append("\n"); 
		query.append("	--RPAD(' ',15,' ') DATA3,	--75 Seal No.  					" ).append("\n"); 
		query.append("	--RPAD(' ',15,' ') DATA4,	--75 Seal No.  					" ).append("\n"); 
		query.append("	--RPAD(' ',15,' ') DATA5,	--75 Seal No.  			" ).append("\n"); 
		query.append("	RPAD(NVL(CNTR_SEAL_NO2,' '),15,' ') DATA1, --95.Seal Number(2중복)" ).append("\n"); 
		query.append("	RPAD(NVL(CNTR_SEAL_NO3,' '),15,' ') DATA2, --96.Seal Number(3중복)" ).append("\n"); 
		query.append("	RPAD(NVL(CNTR_SEAL_NO4,' '),15,' ') DATA3, --97.Seal Number(4중복)" ).append("\n"); 
		query.append("	RPAD(NVL(CNTR_SEAL_NO5,' '),15,' ') DATA4, --98.Seal Number(5중복)" ).append("\n"); 
		query.append("	RPAD(NVL(CNTR_SEAL_NO6,' '),15,' ') DATA5, --99.Seal Number(6중복)" ).append("\n"); 
		query.append("	'4  ' DATA6, --100.Empty/Full Container Identification					" ).append("\n"); 
		query.append("	DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2','22','3','25','4','42','5','45','6','92','7','95','8','92','9','95','95') DATA7, --101.Container Size Code" ).append("\n"); 
		query.append("	DECODE(SUBSTR(CNTR_TPSZ_CD,1,1),'D','GP','R','RT','O','UT','S','UT','F','PF','A','PF','P','PF','T','TN','GP') DATA8, --102.Container Type Code" ).append("\n"); 
		query.append("	'  ' DATA9, --103.Service Type on Delivery Code" ).append("\n"); 
		query.append("	'2  ' DATA10, --104.Container Ownership Code									" ).append("\n"); 
		query.append("	'   ' DATA11, --105.Vanning Type Code							" ).append("\n"); 
		query.append("	'1' DATA12, --106.Customs Convention on Containers (CCC) Application Identifier							" ).append("\n"); 
		query.append("	' ' DATA13 	--107.Automatic Search for Discharged Container Exclusion Identifier" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_BL_CNTR" ).append("\n"); 
		query.append("WHERE	BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND	BL_SPLIT_NO = nvl(@[bl_split_no],'  ')" ).append("\n"); 
		query.append("AND JP_CSTMS_CNTR_STS_CD = 'A'" ).append("\n"); 

	}
}