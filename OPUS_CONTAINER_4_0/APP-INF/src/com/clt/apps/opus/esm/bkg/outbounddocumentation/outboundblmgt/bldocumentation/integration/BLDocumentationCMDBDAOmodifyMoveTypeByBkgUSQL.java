/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOmodifyMoveTypeByBkgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOmodifyMoveTypeByBkgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify Move Type of BKG_BL_ISS by BKG RD Term
	  * </pre>
	  */
	public BLDocumentationCMDBDAOmodifyMoveTypeByBkgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOmodifyMoveTypeByBkgUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_BL_DOC" ).append("\n"); 
		query.append("SET BL_MV_TP_NM" ).append("\n"); 
		query.append("= DECODE(@[rcv_term_cd]||@[de_term_cd],'YY',1 ,'YD',1 ,'YS',3 ,'YT',10,'YO',11,'YM',2 " ).append("\n"); 
		query.append("								      ,'DY',1 ,'DD',1 ,'DS',3 ,'DT',10,'DO',11,'DM',2 " ).append("\n"); 
		query.append("									  ,'SY',7 ,'SD',7 ,'SS',9 ,'ST',14,'SO',15,'SM',8 " ).append("\n"); 
		query.append("									  ,'TY',16,'TD',16,'TS',18,'TT',19,'TO',20,'TM',17" ).append("\n"); 
		query.append("									  ,'IY',21,'ID',21,'IS',23,'IT',24,'IO',25,'IM',22" ).append("\n"); 
		query.append("									  ,'MY',4 ,'MD',4 ,'MS',6 ,'MT',12,'MO',13,'MM',5 )" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_BL_DOC" ).append("\n"); 
		query.append("SET BL_MV_TP_NM" ).append("\n"); 
		query.append("= DECODE(@[rcv_term_cd]||@[de_term_cd],'YY',1 ,'YD',1 ,'YS',3 ,'YT',10,'YO',11,'YM',2 " ).append("\n"); 
		query.append("								      ,'DY',1 ,'DD',1 ,'DS',3 ,'DT',10,'DO',11,'DM',2 " ).append("\n"); 
		query.append("									  ,'SY',7 ,'SD',7 ,'SS',9 ,'ST',14,'SO',15,'SM',8 " ).append("\n"); 
		query.append("									  ,'TY',16,'TD',16,'TS',18,'TT',19,'TO',20,'TM',17" ).append("\n"); 
		query.append("									  ,'IY',21,'ID',21,'IS',23,'IT',24,'IO',25,'IM',22" ).append("\n"); 
		query.append("									  ,'MY',4 ,'MD',4 ,'MS',6 ,'MT',12,'MO',13,'MM',5 )" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}