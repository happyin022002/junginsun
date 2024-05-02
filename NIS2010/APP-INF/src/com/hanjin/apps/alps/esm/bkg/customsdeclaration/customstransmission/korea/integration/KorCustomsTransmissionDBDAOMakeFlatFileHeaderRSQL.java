/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionDAOMakeFlatFileHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.02 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOMakeFlatFileHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MakeFlatFileHeader
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOMakeFlatFileHeaderRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kv_disc_co",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_scac",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_customs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("im_customs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_nbr",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  '$$$MSGSTART:'||" ).append("\n"); 
		query.append("RPAD('SSSMLMM010', 20)||                     /*  Sender ID      */" ).append("\n"); 
		query.append("RPAD('KTNETMFCSS', 20)||                     /*  Receiver ID    */" ).append("\n"); 
		query.append("RPAD('CUSAGD',10)||CHR(10)||                 /*  Message Type   */" ).append("\n"); 
		query.append("'NEWMOD:'       ||'9'            ||CHR(10)|| /*  기능코드        */" ).append("\n"); 
		query.append("'MRNNBR:'       ||@[mrn_nbr]     ||CHR(10)|| /*  MRN_NBR        */" ).append("\n"); 
		query.append("'PARTY:'        ||@[vndr_scac]   ||CHR(10)|| /*  SCAC           */" ).append("\n"); 
		query.append("'DSCH_COM:'     ||@[kv_disc_co]  ||CHR(10)|| /*  선박 대리점 명   */" ).append("\n"); 
		query.append("'PLI:'          ||@[im_customs]  ||CHR(10)|| /*  신고세관        */" ).append("\n"); 
		query.append("'RPLI:'         ||@[loc_customs] ||CHR(10) FLAT_DATA   /*  신고세관과      */" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.customstransmission.korea.integration ").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDAOMakeFlatFileHeaderRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}